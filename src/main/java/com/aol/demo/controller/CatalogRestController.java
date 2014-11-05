package com.aol.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aol.demo.dao.CatalogDao;
import com.aol.demo.model.Product;

@RestController
@RequestMapping("/rest/catalog")
public class CatalogRestController {
	
	@Autowired
	private CatalogDao catalogDao;
	
	@RequestMapping(value="/{sku}", method=RequestMethod.GET)
	public Product getProduct(@PathVariable("sku") String sku) {
		return catalogDao.getProduct(sku);
	}

}
