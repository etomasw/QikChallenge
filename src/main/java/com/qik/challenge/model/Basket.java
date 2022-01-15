package com.qik.challenge.model;

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
    private Integer numberProducts;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private Set<BasketItem> products;

    public Basket(Long id, Integer rawPrice, Integer numberProducts, Set<BasketItem> products) {
        this.id = id;
        this.rawPrice = rawPrice;
        this.numberProducts = numberProducts;
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

    public void setProducts(Set<BasketItem> products) {
        this.products = products;
    }
}
