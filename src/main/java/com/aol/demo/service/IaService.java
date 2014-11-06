package com.aol.demo.service;

import java.util.List;

import com.aol.demo.model.OfferRequest;

public interface IaService {
	List<String> getOffers(OfferRequest request);
}
