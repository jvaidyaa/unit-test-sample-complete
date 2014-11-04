package com.aol.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aol.demo.model.OfferRequest;
import com.aol.demo.model.OfferResponse;
import com.aol.demo.service.OfferService;

@RestController
@RequestMapping("/offers")
public class OffersController {
	
	@Autowired
	private OfferService offerService;
	
	@RequestMapping
	public OfferResponse getProduct(@ModelAttribute OfferRequest request) {
		return offerService.getOffers(request);
	}

}
