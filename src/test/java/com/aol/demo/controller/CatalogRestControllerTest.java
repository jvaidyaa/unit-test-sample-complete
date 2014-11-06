package com.aol.demo.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.aol.demo.dao.CatalogDao;
import com.aol.demo.model.Product;

import static org.mockito.Mockito.*;

public class CatalogRestControllerTest {

	private CatalogRestController catalogRestController;
	private CatalogDao catalogDao;
	
	@Before
	public void setUp() throws Exception {
		catalogRestController = new CatalogRestController();
		
		catalogDao = mock(CatalogDao.class);
		ReflectionTestUtils.setField(catalogRestController, "catalogDao", catalogDao);
	}

	@Test
	public void testGetProduct() {
		// Set Expectations
		when(catalogDao.getProduct(anyString())).thenReturn(new Product());
		
		// Test
		assertNotNull(catalogRestController.getProduct("sample"));
		
		// Verify
		verify(catalogDao).getProduct(anyString());
	}

}
