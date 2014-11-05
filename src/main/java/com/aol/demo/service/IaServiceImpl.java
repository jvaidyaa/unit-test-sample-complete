package com.aol.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aol.demo.dao.IaDao;
import com.aol.demo.model.IaOffersResponse;
import com.aol.demo.model.OfferRequest;

@Service
public class IaServiceImpl implements IaService {

	@Autowired
	private IaDao iaDao;
	
	@Override
	public IaOffersResponse getOffers(OfferRequest request) {
		return new IaOffersResponse(iaDao.getOffers(request));
	}

}
