package com.la.dto;

import java.io.Serializable;

public class FormItemDTO implements Serializable {
    String fieldId;
    String fieldValue;

    public FormItemDTO() {
        super();
    }

    public FormItemDTO(String fieldId, String fieldValue) {
        super();
        this.fieldId = fieldId;
        this.fieldValue = fieldValue;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
