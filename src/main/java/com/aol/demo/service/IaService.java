package com.aol.demo.service;

import com.aol.demo.model.IaOffersResponse;
import com.aol.demo.model.OfferRequest;

public interface IaService {
	IaOffersResponse getOffers(OfferRequest request);
}
