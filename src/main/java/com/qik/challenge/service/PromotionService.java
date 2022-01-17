package com.qik.challenge.service;

import com.qik.challenge.model.Promotion;

import java.util.List;

public interface PromotionService {

    List<Promotion> findAll();
    Promotion findById(Long id);
    Promotion create(Promotion promotion);
}
