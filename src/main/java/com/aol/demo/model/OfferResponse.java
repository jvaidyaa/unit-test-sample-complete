package com.aol.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OfferResponse {
	
	private List<String> offers;
	private List<Product> products = new ArrayList<Product>();
	
	public void setOffers(List<String> offers2) {
		this.offers = offers2;
	}

	public List<String> getOffers() {
		return offers;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	
}
