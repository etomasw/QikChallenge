package com.qik.challenge.service.impl;

import com.qik.challenge.model.BasketItem;
import com.qik.challenge.repository.BasketItemRepository;
import com.qik.challenge.service.BasketItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketItemServiceImpl implements BasketItemService {

    @Autowired
    private BasketItemRepository basketItemRepository;

    @Override
    public BasketItem create(BasketItem basketItem) {
        return basketItemRepository.save(basketItem);
    }

    @Override
    public void delete(Long id) {
        basketItemRepository.deleteById(id);
    }

    @Override
    public BasketItem edit(BasketItem basketItem) {
        return basketItemRepository.save(basketItem);
    }
}
