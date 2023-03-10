package com.example.productorderservicetdd.product.app.service;

import com.example.productorderservicetdd.product.domain.DiscountPolicy;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@NoArgsConstructor
public class AddProductRequest {

    private String name;
    private int price;
    private DiscountPolicy discountPolicy;

    public AddProductRequest(final String name, final int price, final DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");

        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
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
