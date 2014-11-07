package com.aol.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aol.demo.dao.IaDao;
import com.aol.demo.model.OfferRequest;

@Service
public class IaServiceImpl implements IaService {

	@Autowired
	private IaDao iaDao;
	
	@Autowired
	private IaOffersParser iaParser;
	
	@Override
	public List<String> getOffers(OfferRequest request) {
		String offers = iaDao.getOffers(request);
		iaParser.validate(offers);
		return iaParser.toContentIds(offers);
	}

}
