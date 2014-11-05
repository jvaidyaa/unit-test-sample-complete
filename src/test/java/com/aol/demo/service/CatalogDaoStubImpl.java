package com.aol.demo.service;

import com.aol.demo.dao.CatalogDao;
import com.aol.demo.model.Product;

public class CatalogDaoStubImpl implements CatalogDao {

	@Override
	public Product getProduct(String string) {
		Product product = new Product();
		product.setSku(string);
		product.setDescription("blah blah");
		return product;
	}

}
