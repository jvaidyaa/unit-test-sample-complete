package com.aol.demo.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.aol.demo.dao.IaDao;
import com.aol.demo.model.OfferRequest;

import static org.mockito.Mockito.*;

public class IaServiceImplTest {

	private IaServiceImpl iaServiceImpl;
	private IaDao iaDao;
	
	@Before
	public void setUp() throws Exception {
		iaServiceImpl = new IaServiceImpl();
		
		iaDao = mock(IaDao.class);
		ReflectionTestUtils.setField(iaServiceImpl, "iaDao", iaDao);
	}

	@Test
	public void testGetOffers() {
		// Set Expectations
		when(iaDao.getOffers(any(OfferRequest.class))).thenReturn(IaOffersParserTest.iaResponseString);
		
		// Test
		assertNotNull(iaServiceImpl.getOffers(new OfferRequest()));
		
		// Verify
		verify(iaDao).getOffers(any(OfferRequest.class));
	}

}
