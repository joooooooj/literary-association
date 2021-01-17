package com.la.controller;

import com.la.dto.FormFieldsDTO;
import com.la.dto.FormSubmissionDTO;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/auth/registration")
public class RegistrationController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    @GetMapping(value = "/user-input-details")
    public ResponseEntity<FormFieldsDTO> getUserInputDataFormFieldsDTO() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Process_registration");
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list().get(0);
        TaskFormData taskFormData = formService.getTaskFormData(task.getId());
        List<FormField> formFields = taskFormData.getFormFields();

        return new ResponseEntity<>(new FormFieldsDTO(task.getId(), formFields, processInstance.getId()), HttpStatus.OK);
    }

    @PostMapping(value = "/registration/{taskId}")
    public ResponseEntity<?> registration(@RequestBody List<FormSubmissionDTO> formSubmissionDTOS, @PathVariable("taskId") String taskId) {
        System.out.println(taskId);
        HashMap<String, Object> map = this.mapFormItemsToMap(formSubmissionDTOS);
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        runtimeService.setVariable(processInstanceId, "registration", formSubmissionDTOS);
        formService.submitTaskForm(taskId, map);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private HashMap<String, Object> mapFormItemsToMap(List<FormSubmissionDTO> formSubmissionDTOS) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        formSubmissionDTOS.forEach(fi -> {
            map.put(fi.getFieldId(), fi.getFieldValue());
        });
        return map;
    }
}
