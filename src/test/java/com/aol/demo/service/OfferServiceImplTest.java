package com.aol.demo.service;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.aol.demo.dao.CpsDao;
import com.aol.demo.model.CpsProfile;
import com.aol.demo.model.OfferRequest;
import com.aol.demo.model.Product;

import static org.mockito.Mockito.*;

public class OfferServiceImplTest {

	private OfferServiceImpl offerServiceImpl;

	private CpsDao cpsDao;
	private IaService iaService;
	private CatalogService catalogService;

	@Before
	public void setUp() throws Exception {
		offerServiceImpl = new OfferServiceImpl();
		
		cpsDao = mock(CpsDao.class);
		ReflectionTestUtils.setField(offerServiceImpl, "cpsDao", cpsDao);

		iaService = mock(IaService.class);
		ReflectionTestUtils.setField(offerServiceImpl, "iaService", iaService);

		catalogService = mock(CatalogService.class);
		ReflectionTestUtils.setField(offerServiceImpl, "catalogService", catalogService);
	}

	@Test
	public void testGetOffers() {
		// Set expectations
		when(cpsDao.getCpsData(anyString())).thenReturn(mock(CpsProfile.class));
		when(iaService.getOffers(any(OfferRequest.class))).thenReturn(Collections.<String>emptyList());
		when(catalogService.getProducts(anyListOf(String.class))).thenReturn(Collections.<Product>emptyList());
		
		// Test
		assertNotNull(offerServiceImpl.getOffers(new OfferRequest()));
		
		// Verify
		verify(catalogService).getProducts(anyListOf(String.class));
		verify(iaService).getOffers(any(OfferRequest.class));
		verify(cpsDao).getCpsData(anyString());
	}

}
