package com.qik.challenge.service;

import com.qik.challenge.model.Basket;
import com.qik.challenge.model.BasketItem;

public interface BasketService {
    Basket create(Basket basket);
    Basket update(Basket basket);
    void delete(Long id);
    Basket addItem(BasketItem basketItem);
    Basket removeItem(Long basketItemId);
    Basket findById(Long id);
}
