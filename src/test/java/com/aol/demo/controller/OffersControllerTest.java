package com.aol.demo.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.aol.demo.model.OfferRequest;
import com.aol.demo.model.OfferResponse;
import com.aol.demo.service.OfferService;

import static org.mockito.Mockito.*;

public class OffersControllerTest {

	private OffersController offersController;
	private OfferService offerService;
	
	@Before
	public void setUp() throws Exception {
		offersController = new OffersController();
		
		offerService = mock(OfferService.class);
		ReflectionTestUtils.setField(offersController, "offerService", offerService);
	}

	@Test
	public void testGetOffers() {
		// Set Expectations
		when(offerService.getOffers(any(OfferRequest.class))).thenReturn(mock(OfferResponse.class));

		// Test
		assertNotNull(offersController.getOffers(new OfferRequest()));
		
		// Verify
		verify(offerService).getOffers(any(OfferRequest.class));
	}

}
