package com.aol.demo.service;

import java.util.List;

import com.aol.demo.model.Product;

public interface CatalogService {
	List<Product> getProducts(List<String> ids);
}
