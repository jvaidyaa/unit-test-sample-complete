package com.aol.demo.service;

import com.aol.demo.model.OfferRequest;
import com.aol.demo.model.OfferResponse;

public interface OfferService {

	OfferResponse getOffers(OfferRequest request);
	
}
