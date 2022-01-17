package com.qik.challenge.model;

import com.qik.challenge.model.promotions.FlatPromotion;
import com.qik.challenge.model.promotions.GetFreePromotion;
import com.qik.challenge.model.promotions.QuantityPromotion;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rawPrice;
    private double finalPrice;
    private float savings;
    private Integer numberProducts = 0;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Set<BasketItem> products;

    public Basket(Long id, Set<BasketItem> products) {
        this.id = id;
        this.rawPrice = 0;
        this.finalPrice = 0;
        this.savings = 0;
        this.numberProducts = 0;
        this.products = products;
    }

    public Basket() {
        this.rawPrice = 0;
        this.finalPrice = 0;
        this.savings = 0;
        this.numberProducts = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRawPrice() {
        return rawPrice;
    }

    public void setRawPrice(Integer rawPrice) {
        this.rawPrice = rawPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public Integer getNumberProducts() {
        return numberProducts;
    }

    public void setNumberProducts(Integer numberProducts) {
        this.numberProducts = numberProducts;
    }

    public Set<BasketItem> getProducts() {
        return products;
    }

    public void addProduct(BasketItem product) {
        Integer basketItemRawPrice = product.getProduct().getPrice() * product.getQuantity();
        this.rawPrice += basketItemRawPrice;
        this.products.add(product);
        this.numberProducts++;
        calculatePromotions();
    }

    public void setProducts(Set<BasketItem> products) {
        this.products = products;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public float getSavings() {
        return savings;
    }

    public void setSavings(float savings) {
        this.savings = savings;
    }

    public float calculatePromotions() {
        this.savings = 0;
        for(BasketItem b : products) {
            Product product = b.getProduct();
            Integer price = b.getQuantity() * product.getPrice();
            if(product.getPromotions().size() > 0) {
                for(Promotion p : product.getPromotions()) {
                    if(p instanceof FlatPromotion) {
                        FlatPromotion flat = (FlatPromotion) p;
                        this.savings += (price * flat.getPercentDiscount()) / 100.00;
                    } else if(p instanceof GetFreePromotion) {
                        GetFreePromotion getFree = (GetFreePromotion) p;
                        if(b.getQuantity() >= getFree.getRequiredQuantity()) {
                            this.savings += getFree.getFreeQuantity() * price;
                        }
                    } else if(p instanceof QuantityPromotion) {
                        QuantityPromotion quantityPromotion = (QuantityPromotion) p;
                        if(b.getQuantity() >= quantityPromotion.getRequiredQuantity()) {
                            // Example: Non Promo 2 cake: 400 each (800 total)
                            // Promo 2 cake: 750
                            this.savings += (price - quantityPromotion.getPrice());
                        }
                    }
                }
            }
        }
        this.finalPrice = this.rawPrice - savings;
        return savings;
    }
}
