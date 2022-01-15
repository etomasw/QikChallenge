package com.qik.challenge.controller;

import com.qik.challenge.model.Basket;
import com.qik.challenge.repository.BasketItemRepository;
import com.qik.challenge.service.BasketItemService;
import com.qik.challenge.service.BasketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

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

    @PostConstruct
    public void createBasket() {
        Basket basket = new Basket();
        basketService.create(basket);
        LOGGER.info("[!] - BasketController - Created empty Basket - [!]");
    }
}
