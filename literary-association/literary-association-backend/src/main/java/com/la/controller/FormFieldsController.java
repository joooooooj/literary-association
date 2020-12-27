package com.la.controller;

import com.la.dto.FormItemDTO;
import com.la.dto.UserInputDataFormFieldsDTO;
import javafx.util.Pair;
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
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/auth/form-fields")
public class FormFieldsController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private FormService formService;

    @GetMapping(value = "/user-input-details")
    public ResponseEntity<UserInputDataFormFieldsDTO> getUserInputDataFormFieldsDTO() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Process_registration");
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list().get(0);
        TaskFormData taskFormData = formService.getTaskFormData(task.getId());
        List<FormField> formFields = taskFormData.getFormFields();

        return new ResponseEntity<>(new UserInputDataFormFieldsDTO(task.getId(), formFields, processInstance.getId()), HttpStatus.OK);
    }

    @PostMapping(value = "/registration/{taskId}")
    public ResponseEntity<?> registration(@RequestBody List<FormItemDTO> formItemsDTO, @PathVariable("taskId") String taskId) {
        System.out.println(taskId);
        HashMap<String, Object> map = this.mapFormItemsToMap(formItemsDTO);
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        runtimeService.setVariable(processInstanceId, "registration", formItemsDTO);
        formService.submitTaskForm(taskId, map);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private HashMap<String, Object> mapFormItemsToMap(List<FormItemDTO> formItems) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        formItems.forEach(fi -> {
            map.put(fi.getFieldId(), fi.getFieldValue());
        });
        return map;
    }
}
