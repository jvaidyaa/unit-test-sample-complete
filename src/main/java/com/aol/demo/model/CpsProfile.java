package com.aol.demo.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CpsProfile {
	private Map<String, Object> errors;
	private Map<String, Object> nameValuePairs;
	private Integer errorCount;
	private Integer status;
	
	public Map<String, Object> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, Object> errors) {
		this.errors = errors;
	}
	public Map<String, Object> getNameValuePairs() {
		return nameValuePairs;
	}
	public void setNameValuePairs(Map<String, Object> nameValuePairs) {
		this.nameValuePairs = nameValuePairs;
	}
	public Integer getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
