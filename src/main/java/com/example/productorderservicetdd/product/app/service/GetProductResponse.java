package com.example.productorderservicetdd.product.app.service;

import com.example.productorderservicetdd.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public class GetProductResponse {

    private long id;
    private String name;
    private int price;
    private DiscountPolicy discountPolicy;

    public GetProductResponse(long id, String name, int price, DiscountPolicy discountPolicy) {
        Assert.notNull(id, "상품 ID 필수");
        Assert.notNull(name, "상품명 필수");
        Assert.notNull(discountPolicy, "정책 필");
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }
}
