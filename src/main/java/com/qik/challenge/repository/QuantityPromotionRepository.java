package com.qik.challenge.repository;

import com.qik.challenge.model.promotions.QuantityPromotion;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface QuantityPromotionRepository extends PromotionBaseRepository<QuantityPromotion> {
}
