package com.qik.challenge.repository;

import com.qik.challenge.model.promotions.FlatPromotion;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FlatPromotionRepository extends PromotionBaseRepository<FlatPromotion> {
}
