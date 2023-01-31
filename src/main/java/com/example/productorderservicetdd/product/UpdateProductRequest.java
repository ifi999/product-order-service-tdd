package com.example.productorderservicetdd.product;

import lombok.Getter;
import org.springframework.util.Assert;

@Getter
class UpdateProductRequest {
    private String name;
    private int price;
    private DiscountPolicy discountPolicy;

    public UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명 필수");
        Assert.isTrue(price > 0, "가격은 0보다 커야함");
        Assert.notNull(discountPolicy, "정책 필수");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }
}
