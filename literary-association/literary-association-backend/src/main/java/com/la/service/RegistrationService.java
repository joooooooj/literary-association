package com.la.service;

import com.la.dto.FormDto;
import com.la.dto.FormFieldDto;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    FormService formService;

    public FormDto getFormDto() {
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("Registration_Process");

        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).taskId("User_Data_Input").singleResult();

        TaskFormData tfd = formService.getTaskFormData(task.getId());
        List<FormField> properties = tfd.getFormFields();

        return new FormDto(task.getId(), properties, pi.getId());
    }

    public void submitFormDto(List<FormFieldDto> fields, String taskId) {
        HashMap<String, Object> map = this.mapListToDto(fields);

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        runtimeService.setVariable(processInstanceId, "userData", fields);
        formService.submitTaskForm(taskId, map);
    }

    private HashMap<String, Object> mapListToDto(List<FormFieldDto> list)
    {
        HashMap<String, Object> map = new HashMap<String, Object>();
        for(FormFieldDto temp : list){
            map.put(temp.getFieldId(), temp.getFieldValue());
        }

        return map;
    }
}
