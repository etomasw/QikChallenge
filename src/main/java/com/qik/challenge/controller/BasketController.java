package com.qik.challenge.controller;

import com.qik.challenge.model.Basket;
import com.qik.challenge.model.BasketItem;
import com.qik.challenge.model.Product;
import com.qik.challenge.repository.BasketItemRepository;
import com.qik.challenge.service.BasketItemService;
import com.qik.challenge.service.BasketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private BasketItemService basketItemService;
    private BasketService basketService;
    private Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public BasketController(BasketItemService basketItemService, BasketService basketService) {
        this.basketItemService = basketItemService;
        this.basketService = basketService;
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Basket> getBasket(@PathVariable("id") Long id) {
        Basket basket = basketService.findById(id);
        basket.calculatePromotions();
        basketService.update(basket);
        return new ResponseEntity<>(basket, OK);
    }

    @PostMapping("/add/{id}/{basketItemId}")
    public ResponseEntity<Basket> addBasketItem(@PathVariable("id") Long id, @PathVariable("basketItemId") Long basketId) {
        Basket basket = basketService.findById(id);
        BasketItem item = basketItemService.findById(basketId);
        basket.addProduct(item);
        basketService.update(basket);
        LOGGER.info("Products: " + basket.getProducts().size());
        return new ResponseEntity<>(basket, OK);
    }

    @PostConstruct
    public void createBasket() {
        Basket basket = new Basket();
        basketService.create(basket);
        LOGGER.info("[!] - BasketController - Created empty Basket - [!]");
    }
}
