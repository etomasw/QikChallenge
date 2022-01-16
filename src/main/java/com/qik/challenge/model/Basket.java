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

    private Integer rawPrice = 0;
    private Integer numberProducts;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Set<BasketItem> products;

    public Basket(Long id, Set<BasketItem> products) {
        this.id = id;
        this.rawPrice = 0;
        this.numberProducts = 0;
        this.products = products;
    }

    public Basket() {
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
        if(this.numberProducts == null) {
            this.numberProducts = 1;
        } else {
            this.numberProducts++;
        }
    }

    public void setProducts(Set<BasketItem> products) {
        this.products = products;
    }

    public float calculatePromotions() {
        float savings = 0;
        for(BasketItem b : products) {
            Product product = b.getProduct();
            Integer rawPrice = b.getQuantity() * product.getPrice();
            if(product.getPromotions().size() > 0) {
                for(Promotion p : product.getPromotions()) {
                    if(p instanceof FlatPromotion) {
                        FlatPromotion flat = (FlatPromotion) p;
                        savings += (rawPrice * flat.getPercentDiscount()) / 100.00;
                    } else if(p instanceof GetFreePromotion) {

                    } else if(p instanceof QuantityPromotion) {

                    }
                }
            }
        }
        return savings;
    }
}
