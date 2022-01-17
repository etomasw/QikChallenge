package com.qik.challenge.service;

import com.qik.challenge.model.Product;

import java.util.List;

public interface ProductService {

    Product findByUUID(String id);
    List<Product> findAll();
    void loadProducts();
    Product update(Product p);
}
