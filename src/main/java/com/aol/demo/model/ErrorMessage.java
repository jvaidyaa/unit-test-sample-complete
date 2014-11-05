package com.aol.demo.model;

public class ErrorMessage {

	private int value;
	private String message;
	
	public ErrorMessage(int value, String message) {
		this.value = value;
		this.message = message;
	}

	public int getValue() {
		return value;
	}

	public String getMessage() {
		return message;
	}

	
}
