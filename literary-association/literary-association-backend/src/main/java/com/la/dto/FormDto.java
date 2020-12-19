package com.la.dto;

import org.camunda.bpm.engine.form.FormField;
import java.util.List;

public class FormDto {

    String taskId;
    List<FormField> formFields;
    String processInstanceId;

    public FormDto() {
    }

    public FormDto(String taskId, List<FormField> formFields, String processInstanceId) {
        this.taskId = taskId;
        this.formFields = formFields;
        this.processInstanceId = processInstanceId;
    }

    public String getTaskId() {
        return taskId;
    }

    public List<FormField> getFormFields() {
        return formFields;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setFormFields(List<FormField> formFields) {
        this.formFields = formFields;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    @Override
    public String toString() {
        return "RegistrationFormDto{" +
                "taskId='" + taskId + '\'' +
                ", formFields=" + formFields +
                ", processInstanceId='" + processInstanceId + '\'' +
                '}';
    }
}
