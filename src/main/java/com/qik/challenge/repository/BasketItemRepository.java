package com.qik.challenge.repository;

import com.qik.challenge.model.BasketItem;
import org.springframework.data.repository.CrudRepository;

public interface BasketItemRepository extends CrudRepository<BasketItem, Long> {
}
