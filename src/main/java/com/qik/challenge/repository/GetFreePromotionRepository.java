package com.qik.challenge.repository;

import com.qik.challenge.model.promotions.GetFreePromotion;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GetFreePromotionRepository extends PromotionBaseRepository<GetFreePromotion> {
}
