package com.qik.challenge.repository;

import com.qik.challenge.model.Basket;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Long> {
}
