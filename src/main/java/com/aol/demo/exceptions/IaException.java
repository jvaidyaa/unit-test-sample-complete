package com.aol.demo.exceptions;

public class IaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IaException(String error, String causedBy) {
		super(String.format("IAException: %s, Caused by: %s", error, causedBy));
	}

}
