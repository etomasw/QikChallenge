package com.qik.challenge.repository;

import com.qik.challenge.model.Promotion;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PromotionRepository extends PromotionBaseRepository<Promotion> {
}
