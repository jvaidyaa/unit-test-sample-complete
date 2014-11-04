package com.aol.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OfferResponse {

	private String offers;
	
	public String getOffers() {
		return offers;
	}
	public void setOffers(String offers) {
		this.offers = offers;
	}
}
