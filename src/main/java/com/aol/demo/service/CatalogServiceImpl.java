package com.aol.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aol.demo.dao.CatalogDao;
import com.aol.demo.model.Product;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private CatalogDao catalogDao;
	
	@Override
	public List<Product> getProducts(List<String> ids) {
		List<Product> products = new ArrayList<Product>();
		for (String id : ids) {
			products.add(catalogDao.getProduct(id));
		}
		
		return products;
	}

}
