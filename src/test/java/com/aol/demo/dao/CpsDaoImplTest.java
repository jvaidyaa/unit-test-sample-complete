package com.aol.demo.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.aol.demo.model.CpsProfile;

import static org.mockito.Mockito.*;

public class CpsDaoImplTest {

	private CpsDaoImpl cpsDaoImpl;
	private RestTemplate restTemplate;
	
	@Before
	public void setUp() throws Exception {
		cpsDaoImpl = new CpsDaoImpl();
		
		restTemplate = mock(RestTemplate.class);
		ReflectionTestUtils.setField(cpsDaoImpl, "restTemplate", restTemplate);
	}

	@Test
	public void testGetCpsDataScreenname() {
		// Set expectations
		when(restTemplate.getForObject(anyString(), eq(CpsProfile.class))).thenReturn(mock(CpsProfile.class));
		
		// Test
		assertNotNull(cpsDaoImpl.getCpsData("viktest2"));
		
		// Verify
		verify(restTemplate).getForObject(anyString(), eq(CpsProfile.class));
	}

	@Test
	public void testGetCpsDataAccountNumber() {
		// Set expectations
		when(restTemplate.getForObject(anyString(), eq(CpsProfile.class))).thenReturn(mock(CpsProfile.class));
		
		// Test
		assertNotNull(cpsDaoImpl.getCpsData("1000007"));
		
		// Verify
		verify(restTemplate).getForObject(anyString(), eq(CpsProfile.class));
	}

}
