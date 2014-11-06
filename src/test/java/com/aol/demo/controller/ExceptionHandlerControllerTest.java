package com.aol.demo.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.aol.demo.exceptions.IaException;
import com.aol.demo.model.ErrorMessage;

public class ExceptionHandlerControllerTest {

	private ExceptionHandlerController exceptionHandlerController;
	
	@Before
	public void setUp() throws Exception {
		exceptionHandlerController = new ExceptionHandlerController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHandleHttpServerException() throws Exception {
		ErrorMessage errorMessage = exceptionHandlerController.handleHttpServerException(new HttpServerErrorException(HttpStatus.SERVICE_UNAVAILABLE, "error"));
		assertNotNull(errorMessage);
	}

	@Test
	public void testHandleHttpMessageNotReadableException() throws Exception {
		ErrorMessage errorMessage = exceptionHandlerController.handleHttpMessageNotReadableException(new HttpMessageNotReadableException("error"));
		assertNotNull(errorMessage);
	}

	@Test
	public void testHandleMissingServletRequestParameterException() throws Exception {
		ErrorMessage errorMessage = exceptionHandlerController.handleMissingServletRequestParameterException(new MissingServletRequestParameterException("error", "String"));
		assertNotNull(errorMessage);
	}

	@Test
	public void testHandleHttpClientErrorException() throws Exception {
		ErrorMessage errorMessage = exceptionHandlerController.handleHttpClientErrorException(new HttpClientErrorException(HttpStatus.NOT_FOUND, "error"));
		assertNotNull(errorMessage);
	}

	@Test
	public void testHandleIaException() throws Exception {
		ErrorMessage errorMessage = exceptionHandlerController.handleIaException(new IaException("", ""));
		assertNotNull(errorMessage);
	}


	@Test
	public void testHandleException() throws Exception {
		ErrorMessage errorMessage = exceptionHandlerController.handleException(new Exception(""));
		assertNotNull(errorMessage);
	}

}
