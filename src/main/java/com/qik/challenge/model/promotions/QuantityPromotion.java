package com.qik.challenge.model.promotions;

import com.qik.challenge.enums.PromotionType;
import com.qik.challenge.model.Promotion;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("QUANTITY")
public class QuantityPromotion extends Promotion {

    @Enumerated(value = EnumType.STRING)
    private PromotionType promotionType;
    private Integer requiredQuantity;
    private Integer price;

    public QuantityPromotion(PromotionType promotionType, Integer requiredQuantity, Integer price) {
        this.promotionType = promotionType;
        this.requiredQuantity = requiredQuantity;
        this.price = price;
    }

    public QuantityPromotion() {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
