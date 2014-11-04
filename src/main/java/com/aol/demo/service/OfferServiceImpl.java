package com.aol.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aol.demo.dao.CatalogDao;
import com.aol.demo.dao.CpsDao;
import com.aol.demo.dao.IaDao;
import com.aol.demo.model.OfferRequest;
import com.aol.demo.model.OfferResponse;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private CpsDao cpsDao;
	
	@Autowired
	private IaDao iaDao;
	
	@Autowired
	private CatalogDao catalogDao;
	
	@Override
	public OfferResponse getOffers(OfferRequest request) {
		String offers = iaDao.getOffers(request);
		OfferResponse response = new OfferResponse();
		response.setOffers(offers);
		
		return response;
	}

}
