package com.qik.challenge.repository;

import com.qik.challenge.model.Promotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PromotionBaseRepository<T extends Promotion> extends CrudRepository<T, Long> {

}
