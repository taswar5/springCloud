package com.catalogue.service.service;

import com.catalogue.service.model.Product;
import com.catalogue.service.util.InitializeProducts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {
    public List<Product> getAllProducts() {
        return InitializeProducts.initializeAllProducts();
    }
}
