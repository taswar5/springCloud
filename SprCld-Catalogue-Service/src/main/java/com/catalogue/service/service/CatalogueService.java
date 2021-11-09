package com.catalogue.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.catalogue.service.model.Product;
import com.catalogue.service.util.InitializeProducts;

@Service
public class CatalogueService {
	public List<Product> getAllProducts(){
		return InitializeProducts.initializeAllProducts();
	}
}
