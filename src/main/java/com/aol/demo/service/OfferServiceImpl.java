package com.aol.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aol.demo.dao.CpsDao;
import com.aol.demo.model.CpsProfile;
import com.aol.demo.model.IaOffersResponse;
import com.aol.demo.model.OfferRequest;
import com.aol.demo.model.OfferResponse;
import com.aol.demo.utils.JsonUtils;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private CpsDao cpsDao;
	
	@Autowired
	private IaService iaService;
	
	@Autowired
	private CatalogService catalogService;
	
	@Override
	public OfferResponse getOffers(OfferRequest request) {
		// Get Profile & enrich Request with customer data
		CpsProfile profile = cpsDao.getCpsData(request.getSessionId());
		request.setCustomerData(JsonUtils.toJsonString(profile.getNameValuePairs()));
		
		// Get offers
		IaOffersResponse offers = iaService.getOffers(request);
		OfferResponse response = new OfferResponse();
		response.setOffers(offers);
		
		// Enrich response with ecommerce data
		response.getProducts().addAll(catalogService.getProducts(offers.getContentIds()));
		
		// Return response
		return response;
	}

}
