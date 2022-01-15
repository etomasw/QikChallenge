package com.qik.challenge.model.promotions;

import com.qik.challenge.enums.PromotionType;
import com.qik.challenge.model.Promotion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "FLAT")
public class FlatPromotion extends Promotion {

    @Enumerated(value = EnumType.STRING)
    private PromotionType promotionType;
    private Integer percentDiscount;

    public FlatPromotion() {
    }

    public FlatPromotion(PromotionType promotionType, Integer percentDiscount) {
        this.promotionType = promotionType;
        this.percentDiscount = percentDiscount;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public Integer getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(Integer percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
}
