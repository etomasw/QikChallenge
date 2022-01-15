package com.qik.challenge.controller;

import com.qik.challenge.model.Product;
import com.qik.challenge.repository.ProductRepository;
import com.qik.challenge.service.ProductService;
import com.qik.challenge.service.impl.PromotionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Product> getProductByUUID(@PathVariable("uuid") String uuid) {
        Product p = productService.findByUUID(uuid);
        return new ResponseEntity<>(productService.findByUUID(uuid), OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.findAll(), OK);
    }

    @PostConstruct
    public void setupProducts() {
        LOGGER.info("[!] - ProductController - PostConstructor started, loading products - [!]");
        productService.loadProducts();
    }
}
