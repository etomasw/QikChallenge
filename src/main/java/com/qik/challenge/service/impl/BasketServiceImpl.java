package com.qik.challenge.service.impl;

import com.qik.challenge.model.Basket;
import com.qik.challenge.model.BasketItem;
import com.qik.challenge.repository.BasketRepository;
import com.qik.challenge.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketRepository basketRepository;

    @Override
    public Basket create(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public Basket update(Basket basket) {
        return null;
    }

    @Override
    public void delete(Long id) {
        basketRepository.deleteById(id);
    }

    @Override
    public Basket addItem(BasketItem basketItem) {
        return null;
    }

    @Override
    public Basket removeItem(Long basketItemId) {
        return null;
    }
}
