package com.qik.challenge.service;

import com.qik.challenge.model.BasketItem;

public interface BasketItemService {
    BasketItem create(BasketItem basketItem);
    void delete(Long id);
    BasketItem edit(BasketItem basketItem);
}
