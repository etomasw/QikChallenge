package com.qik.challenge.controller;

import com.qik.challenge.model.Basket;
import com.qik.challenge.model.BasketItem;
import com.qik.challenge.service.BasketItemService;
import com.qik.challenge.service.BasketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/basket-item")
public class BasketItemController {

    private BasketItemService basketItemService;
    private Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public BasketItemController(BasketItemService basketItemService) {
        this.basketItemService = basketItemService;
    }

    @PostMapping("/add")
    public ResponseEntity<BasketItem> createBasketItem(@RequestBody BasketItem basketItem) {
        BasketItem b = new BasketItem();
        b.setQuantity(basketItem.getQuantity());
        b.setProduct(basketItem.getProduct());
        return new ResponseEntity<>(basketItemService.create(b), OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BasketItem> getBasketItem(@PathVariable("id") Long id) {
        return new ResponseEntity<>(basketItemService.findById(id), OK);
    }

    @GetMapping("")
    public ResponseEntity<List<BasketItem>> getAll() {
        return new ResponseEntity<>(basketItemService.findAll(), OK);
    }
}
