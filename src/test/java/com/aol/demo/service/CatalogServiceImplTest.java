package com.aol.demo.service;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.aol.demo.dao.CatalogDao;
import com.aol.demo.model.Product;

import static org.mockito.Mockito.*;

public class CatalogServiceImplTest {

	private CatalogServiceImpl catalogServiceImpl;
	private CatalogDao catalogDao;
	
	@Before
	public void setUp() throws Exception {
		catalogServiceImpl = new CatalogServiceImpl();
		
		catalogDao = mock(CatalogDao.class);
		ReflectionTestUtils.setField(catalogServiceImpl, "catalogDao", catalogDao);
	}

	@Test
	public void testGetProducts() {
		// Set Expectations
		when(catalogDao.getProduct(anyString())).thenReturn(mock(Product.class));
		
		// Test
		assertFalse(catalogServiceImpl.getProducts(Arrays.asList("a", "b")).isEmpty());
		
		// Verify
		verify(catalogDao, atLeastOnce()).getProduct(anyString());
	}

}
