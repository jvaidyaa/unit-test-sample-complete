package com.aol.demo.dao;

import com.aol.demo.model.Product;

public interface CatalogDao {
	Product getProduct(String sku);
}
