package com.la.controller;

import com.la.dto.FormFieldsDTO;
import com.la.dto.FormSubmissionDTO;
import com.la.security.TokenUtils;
import com.la.service.UserService;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "publish")
public class PublishBookController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    FormService formService;

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    UserService userService;

    @GetMapping(value = "/writer/form/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormFieldsDTO> getFormFields(@PathVariable String token) {
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("Publish_Book");
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).list().get(0);

        // GET LOGGED IN WRITER USERNAME
        System.err.println("Token : " + token);
        String username = tokenUtils.getUsernameFromToken("Bearer " + token);
        System.err.println("Username : " + username);

        // CREATE CAMUNDA USER IF DOES NOT EXIST, RETURN ID
        User camundaUser = userService.createCamundaUser(username);
        // EXE ID, VARIABLE NAME, VALUE
        runtimeService.setVariable(task.getExecutionId(), "writer", camundaUser);
        System.err.println("Setovana varijabla 'writer' : " + runtimeService.getVariables(task.getExecutionId()).get("writer"));

        // GET TASK FORM DATA
        TaskFormData taskFormData = formService.getTaskFormData(task.getId());
        List<FormField> formFields = taskFormData.getFormFields();

        System.err.println(runtimeService.getVariables(task.getExecutionId()));

        // ADD GENRES TO OPTIONS PROPERTY
        Object genres = runtimeService.getVariables(task.getExecutionId()).get("genres");
        String genresString = String.valueOf(genres);
        System.err.println(genresString);

        formFields.get(1).getProperties().put("options", genresString);

        return new ResponseEntity<>(new FormFieldsDTO(task.getId(), pi.getId(), formFields), HttpStatus.OK);
    }

    @PostMapping(value = "/writer/form/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> postForm(@RequestBody List<FormSubmissionDTO> fieldValues, @PathVariable String taskId) {
        HashMap<String, Object> map = this.mapListToDto(fieldValues);

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        runtimeService.setVariable(processInstanceId, "publishFormValues", fieldValues);
        formService.submitTaskForm(taskId, map);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private HashMap<String, Object> mapListToDto(List<FormSubmissionDTO> list)
    {
        HashMap<String, Object> map = new HashMap<String, Object>();
        for(FormSubmissionDTO temp : list){
            map.put(temp.getFieldId(), temp.getFieldValue());
        }

        return map;
    }
}