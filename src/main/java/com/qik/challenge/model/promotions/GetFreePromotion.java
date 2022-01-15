package com.qik.challenge.model.promotions;

import com.qik.challenge.enums.PromotionType;
import com.qik.challenge.model.Promotion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("GETFREE")
public class GetFreePromotion extends Promotion {

    @Enumerated(value = EnumType.STRING)
    private PromotionType promotionType;
    private Integer requiredQuantity;
    private Integer freeQuantity;

    public GetFreePromotion() {
    }

    public GetFreePromotion(PromotionType promotionType, Integer requiredQuantity, Integer freeQuantity) {
        this.promotionType = promotionType;
        this.requiredQuantity = requiredQuantity;
        this.freeQuantity = freeQuantity;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public Integer getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(Integer requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public Integer getFreeQuantity() {
        return freeQuantity;
    }

    public void setFreeQuantity(Integer freeQuantity) {
        this.freeQuantity = freeQuantity;
    }
}
