package com.la.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.camunda.bpm.engine.form.FormField;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FormFieldsDTO {
	String taskId;
	List<FormField> formFields;
	String processInstanceId;

	@Override
	public String toString() {
		return "FormFieldsDTO{" +
				"taskId='" + taskId + '\'' +
				", formFields=" + formFields +
				", processInstanceId='" + processInstanceId + '\'' +
				'}';
	}
}
