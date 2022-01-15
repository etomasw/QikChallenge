package com.qik.challenge.controller;

import com.qik.challenge.model.Product;
import com.qik.challenge.model.Promotion;
import com.qik.challenge.service.ProductService;
import com.qik.challenge.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

    private PromotionService promotionService;
    private ProductService productService;

    @Autowired
    public PromotionController(PromotionService promotionService, ProductService productService) {
        this.promotionService = promotionService;
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Promotion>> getPromotions() {
        return new ResponseEntity<>(promotionService.findAll(), OK);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Promotion> addPromotion(@PathVariable("id") Long promotionId, @RequestBody Product product) {
        Promotion promotion = promotionService.findById(promotionId);
        Product p = productService.findByUUID(product.getId());
        p.getPromotions().add(promotion);
        productService.update(p);
        return new ResponseEntity<>(promotion, OK);
    }


}
