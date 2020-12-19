package com.la.dto;

public class FormFieldDto {

    String fieldId;
    String fieldValue;

    public FormFieldDto() {
    }

    public FormFieldDto(String fieldId, String fieldValue) {
        this.fieldId = fieldId;
        this.fieldValue = fieldValue;
    }

    public String getFieldId() {
        return fieldId;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public String toString() {
        return "RegSubmitFormDto{" +
                "fieldId='" + fieldId + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                '}';
    }
}
