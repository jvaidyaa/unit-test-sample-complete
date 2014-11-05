package com.aol.demo.service;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.aol.demo.dao.CatalogDao;

public class CatalogServiceImplTestWithStub {

	private CatalogServiceImpl catalogServiceImpl;
	private CatalogDao catalogDao;
	
	@Before
	public void setUp() throws Exception {
		catalogServiceImpl = new CatalogServiceImpl();
		
		catalogDao = new CatalogDaoStubImpl();
		ReflectionTestUtils.setField(catalogServiceImpl, "catalogDao", catalogDao);
	}

	@Test
	public void testGetProducts() {
		// Test
		assertFalse(catalogServiceImpl.getProducts(Arrays.asList("a", "b")).isEmpty());
	}

}
