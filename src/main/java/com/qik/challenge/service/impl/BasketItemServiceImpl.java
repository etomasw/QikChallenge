package com.qik.challenge.service.impl;

import com.qik.challenge.model.BasketItem;
import com.qik.challenge.repository.BasketItemRepository;
import com.qik.challenge.service.BasketItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public BasketItem findById(Long id) {
        return basketItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<BasketItem> findAll() {
        List<BasketItem> list = new ArrayList<>();
        basketItemRepository.findAll().forEach(list::add);
        return list;
    }
}
