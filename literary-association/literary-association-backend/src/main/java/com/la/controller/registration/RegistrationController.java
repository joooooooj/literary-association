package com.la.controller.registration;

import com.la.dto.FormFieldsDTO;
import com.la.dto.FormSubmissionDTO;
import com.la.model.dtos.WriterMembershipRequestDataNeededDTO;
import com.la.model.enums.WriterMembershipStatus;
import com.la.model.registration.WriterMembershipRequest;
import com.la.repository.WriterMembershipRequestRepository;
import com.la.security.TokenUtils;
import com.la.service.file.FileService;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/registration")
public class RegistrationController {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private WriterMembershipRequestRepository writerMembershipRequestRepository;

    @Autowired
    private FileService fileService;

    // 6.1 KORAK / PREDUSLOV
    @GetMapping(value = "/request/self/{token:.+}")
    public ResponseEntity<?> getDataNeeded(@PathVariable String token) {
        String username = tokenUtils.getUsernameFromToken(token);
        User user = identityService.createUserQuery().userId(username).singleResult();

        if (user != null) {
            WriterMembershipRequest request = writerMembershipRequestRepository.findByUsername(username);

            WriterMembershipRequestDataNeededDTO dataNeeded = new WriterMembershipRequestDataNeededDTO();
            dataNeeded.setAttemptsNumber(request.getAttemptsNumber());
            dataNeeded.setPaymentDeadline(request.getPaymentDeadline());
            dataNeeded.setStatus(request.getStatus());
            dataNeeded.setSubmissionDeadline(request.getSubmissionDeadline());

            return new ResponseEntity<>(dataNeeded, HttpStatus.OK);
        }
        return new ResponseEntity<>("Not existing user", HttpStatus.BAD_REQUEST);
    }

    // 6.2 KORAK / DOBAVLJANJE FORME ZA UPLOAD 2 PDFA
    @GetMapping(value = "/upload-work-form")
    public ResponseEntity<FormFieldsDTO> getUploadWorkForm(@RequestHeader("Authorization") String token) {
        token = token.substring(7);
        String username = tokenUtils.getUsernameFromToken(token);

        ProcessInstance processInstance = hasUserAlreadyStartedProcess("Process_registration", username);

        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list().get(0);
        TaskFormData taskFormData = formService.getTaskFormData(task.getId());
        List<FormField> formFields = taskFormData.getFormFields();

        return new ResponseEntity<>(new FormFieldsDTO(task.getId(), formFields, processInstance.getId(),
                "http://localhost:8080/api/registration/writer-upload/", "http://localhost:8080/api/registration/upload-submitted-work/"), HttpStatus.OK);
    }

    // 7.1 KORAK / SLANJE UPLOADOVANIH PDF FAJLOVA
    @PostMapping(value = "/upload-submitted-work/{processInstanceId}")
    public ResponseEntity<?> uploadSubmittedWork(@RequestBody MultipartFile file, @PathVariable String processInstanceId) {
        try {
            if (file != null) {
                String path = fileService.saveUploadedFile(file, processInstanceId);

                String username = (String) runtimeService.getVariable(processInstanceId, "registeredUser");
                WriterMembershipRequest request = writerMembershipRequestRepository.findByUsername(username);
                request.setStatus(WriterMembershipStatus.WAITING_OPINION);
                writerMembershipRequestRepository.save(request);

                // DODATI CUVANJE SUBMITTED WORKA

                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // 7.2 / SLANJE FORME PDFOVA ZA CAMUNDU
    @PostMapping(value = "/writer-upload/{taskId}")
    public ResponseEntity<HttpStatus> postUploadFileForm(@RequestBody List<FormSubmissionDTO> fieldValues, @PathVariable String taskId) {
        HashMap<String, Object> map = this.mapListToDto(fieldValues);
        formService.submitTaskForm(taskId, map);

        System.err.println("POST UPLOAD FILE FORM . . .");

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

    private ProcessInstance hasUserAlreadyStartedProcess(String processDefinitionId, String userId) {
        List<ProcessInstance> processInstances = getAllRunningProcessInstances(processDefinitionId);

        for (ProcessInstance processInstance : processInstances) {
            String username = (String) runtimeService.getVariable(processInstance.getId(), "registeredUser");
            if (username.equals(userId)) {
//                System.err.println("User already started this process.");
                return processInstance;
            }
        }
        return null;
    }

}
