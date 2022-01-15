package com.qik.challenge.service;

import com.qik.challenge.model.BasketItem;

import java.util.List;

public interface BasketItemService {
    BasketItem create(BasketItem basketItem);
    void delete(Long id);
    BasketItem edit(BasketItem basketItem);
    BasketItem findById(Long id);
    List<BasketItem> findAll();
}
