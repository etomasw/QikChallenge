package com.qik.challenge.service.impl;

import com.qik.challenge.model.Product;
import com.qik.challenge.repository.ProductRepository;
import com.qik.challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.qik.challenge.constant.ApiConstant.GET_ALL_PRODUCTS_API;

@Service
public class ProductServiceImpl implements ProductService {

    private final RestTemplate restTemplate;

    @Autowired
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("restTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product findByUUID(String id) {
        return repository.findProductById(id);
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        repository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public void loadProducts() {
        for(Product p : loadProductsFromAPI()) {
            Product save = new Product();
            save.setName(p.getName());
            save.setPrice(p.getPrice());
            save.setId(p.getId());
            repository.save(save);
        }
    }

    @Override
    public void update(Product p) {
        repository.save(p);
    }

    private List<Product> loadProductsFromAPI() {
        return Arrays.asList(restTemplate.getForEntity(GET_ALL_PRODUCTS_API, Product[].class).getBody());
    }
}
