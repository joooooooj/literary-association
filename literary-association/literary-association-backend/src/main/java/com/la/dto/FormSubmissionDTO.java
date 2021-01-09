package com.la.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormSubmissionDTO implements Serializable{
	
	private String fieldId;
	private String fieldValue;

	@Override
	public String toString() {
		return "FormSubmissionDTO{" +
				"fieldId='" + fieldId + '\'' +
				", fieldValue='" + fieldValue + '\'' +
				'}';
	}
}
