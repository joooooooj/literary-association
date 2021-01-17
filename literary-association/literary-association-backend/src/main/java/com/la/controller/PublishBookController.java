package com.la.controller;

import com.la.dto.FormFieldsDTO;
import com.la.dto.FormSubmissionDTO;
import com.la.model.enums.PublishStatus;
import com.la.model.publish.Decision;
import com.la.model.publish.EditorRequestView;
import com.la.model.publish.PublishBookRequest;
import com.la.security.TokenUtils;
import com.la.service.PublishBookService;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "publish")
@CrossOrigin
public class PublishBookController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private PublishBookService publishBookService;

    @GetMapping(value = "/writer/status/{token:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublishBookRequest> getWriterStatus(@PathVariable String token) {
        // GET LOGGED IN WRITER USERNAME
        String username = tokenUtils.getUsernameFromToken(token);
        User user = identityService.createUserQuery().userId(username).singleResult();

        // Get Writer Publish Book Info
        ProcessInstance processInstance = hasUserAlreadyStartedProcess("Publish_Book", user.getId());
        PublishBookRequest publishBookRequest = (PublishBookRequest) runtimeService.getVariable(processInstance.getId(), "publishBookRequest");

        return new ResponseEntity<>(publishBookRequest, HttpStatus.OK);
    }

    @GetMapping(value = "/writer/form/{token:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormFieldsDTO> getFormFieldsWriter(@PathVariable String token) {
        // GET LOGGED IN WRITER USERNAME
        String username = tokenUtils.getUsernameFromToken(token);
        User user = identityService.createUserQuery().userId(username).singleResult();

        // CAMUNDA USER EXISTS?
        if (user != null) {
            // CHECKING IF USER ALREADY STARTED THIS PROCESS
            ProcessInstance processInstance = hasUserAlreadyStartedProcess("Publish_Book", user.getId());
            if (processInstance != null){
                // CHECK IF HE STILL DIDN'T SUBMIT (CURRENTLY ACTIVE TASK IN PROCESS IS WRITER_PUBLISH_FORM)
                Task task = taskService.createTaskQuery().active().processInstanceId(processInstance.getId()).singleResult();
                if (task.getTaskDefinitionKey().equals("Writer_Publish_Form")){
                    // SEND WRITER FIELDS FOR PUBLISH BOOK FORM
                    List<FormField> formFields = formService.getTaskFormData(task.getId()).getFormFields();
                    return new ResponseEntity<>(new FormFieldsDTO(task.getId(), formFields, processInstance.getId()), HttpStatus.OK);
                }
                else{
                    // HE ALREADY SUBMITTED
                    // WE CALL ON FRONTEND PROCESS STATUS VARIABLE
                    System.err.println("Sending no response");
                    FormFieldsDTO formFieldsDTO = new FormFieldsDTO();
                    return new ResponseEntity<>(formFieldsDTO, HttpStatus.OK);
                }
            }
            System.err.println("Writer publishing first time ... ");
            // IF USER DIDNT ALREADY STARTED PROCESS
            ProcessInstance pi = runtimeService.startProcessInstanceByKey("Publish_Book");
            runtimeService.setVariable(pi.getId(), "writer", user.getId());

            // GET FIRST TASK
            Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).list().get(0);

            task.setAssignee(user.getId());
            taskService.saveTask(task);

            // GET TASK FORM DATA
            TaskFormData taskFormData = formService.getTaskFormData(task.getId());
            List<FormField> formFields = taskFormData.getFormFields();

            // ADD GENRES TO OPTIONS PROPERTY
            Object genres = runtimeService.getVariables(task.getExecutionId()).get("genres");
            String genresString = String.valueOf(genres);

            formFields.get(1).getProperties().put("options", genresString);

            // SEND WRITER FIELDS FOR PUBLISH BOOK FORM
            return new ResponseEntity<>(new FormFieldsDTO(task.getId(), formFields, pi.getId()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(value = "/writer/form/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> postFormWriter(@RequestBody List<FormSubmissionDTO> fieldValues, @PathVariable String taskId) {
        HashMap<String, Object> map = this.mapListToDto(fieldValues);

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        PublishBookRequest publishBookRequest = publishBookService.makePublishBookRequest(map, task.getAssignee());
        runtimeService.setVariable(processInstanceId, "publishBookRequest", publishBookRequest);
        formService.submitTaskForm(taskId, map);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/editor/requests/{token:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EditorRequestView>> getRequestsEditor(@PathVariable String token) {
        // GET LOGGED IN EDITOR USERNAME
        String username = tokenUtils.getUsernameFromToken(token);
        User user = identityService.createUserQuery().userId(username).singleResult();

        // Editor exists as camunda user
        if (user != null){
            List<ProcessInstance> processInstances = getAllRunningProcessInstances("Publish_Book");
            System.err.println(processInstances);

            PublishBookRequest publishBookRequest;
            Task task;

            List<EditorRequestView> editorRequestViews = new ArrayList<>();

            for(ProcessInstance processInstance : processInstances){
                task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskAssignee(username).active().singleResult();
                if (task != null){
                    publishBookRequest = (PublishBookRequest) runtimeService.getVariable(task.getExecutionId(), "publishBookRequest");

                    EditorRequestView editorRequestView = new EditorRequestView();
                    editorRequestView.setTaskId(task.getId());
                    editorRequestView.setProcessInstanceId(processInstance.getId());
                    editorRequestView.setPublishBookRequest(publishBookRequest);
                    System.err.println(editorRequestView);
                    editorRequestViews.add(editorRequestView);
                }
            }
            return new ResponseEntity<>(editorRequestViews, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(value = "/editor/decision/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormFieldsDTO> postFormEditor(@RequestBody Decision decision, @PathVariable String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();

        runtimeService.setVariable(processInstanceId, "editorApproved", decision.getApproved());
        taskService.complete(taskId);

        if (decision.getApproved()){
            PublishBookRequest publishBookRequest = (PublishBookRequest) runtimeService.getVariable(processInstanceId, "publishBookRequest");
            // Set request status
            // Set deadline
            publishBookRequest.setStatus(PublishStatus.WAITING_SUBMIT.toString());
            publishBookRequest.setDeadline((DateTime.now().plusDays(10)).toLocalDate().toString());
            runtimeService.setVariable(processInstanceId, "publishBookRequest", publishBookRequest);
        }
        // If rejecting initiated send form fields from next task and wait for final deny
        if (!decision.getApproved()){
            Task nextTask = taskService.createTaskQuery().processInstanceId(processInstanceId).active().singleResult();
            TaskFormData taskFormData = formService.getTaskFormData(nextTask.getId());
            List<FormField> formFields = taskFormData.getFormFields();
            return new ResponseEntity<>(new FormFieldsDTO(nextTask.getId(), formFields, processInstanceId), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(value = "/editor/refuse/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> postFormEditorRefuse(@RequestBody List<FormSubmissionDTO> fieldValues, @PathVariable String taskId) {
        HashMap<String, Object> map = this.mapListToDto(fieldValues);

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        runtimeService.setVariable(processInstanceId, "explanation", fieldValues.get(0).getFieldValue());
        formService.submitTaskForm(taskId, map);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private HashMap<String, Object> mapListToDto(List<FormSubmissionDTO> list) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        for (FormSubmissionDTO temp : list) {
            map.put(temp.getFieldId(), temp.getFieldValue());
        }

        return map;
    }

    private List<ProcessInstance> getAllRunningProcessInstances(String processDefinitionId) {
        // query for latest process definition with given name
        ProcessDefinition myProcessDefinition =
                repositoryService.createProcessDefinitionQuery()
                        .processDefinitionName(processDefinitionId)
                        .latestVersion()
                        .singleResult();

        // list all running/unsuspended instances of the process
        List<ProcessInstance> processInstances =
                runtimeService.createProcessInstanceQuery()
                        .processDefinitionId(myProcessDefinition.getId())
                        .active() // we only want the unsuspended process instances
                        .list();

        return processInstances;
    }

    private ProcessInstance hasUserAlreadyStartedProcess(String processDefinitionId, String userId){
        List<ProcessInstance> processInstances = getAllRunningProcessInstances(processDefinitionId);

        for(ProcessInstance processInstance : processInstances){
            String username = (String) runtimeService.getVariable(processInstance.getId(), "writer");
            if (username.equals(userId)) {
                System.err.println("User already started this process.");
                return processInstance;
            }
        }
        return null;
    }
}
