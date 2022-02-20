package com.catalogue.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {

    private int productId;
    private String name;
    private double price;
    private boolean isAvailable;

}
