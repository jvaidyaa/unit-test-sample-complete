package com.aol.demo.dao;

import com.aol.demo.model.ecommerce.Product;

public interface CatalogDao {
	Product getProduct(String sku);
}
