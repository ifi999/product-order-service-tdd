package com.example.productorderservicetdd.order.app.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Getter
@NoArgsConstructor
public class CreateOrderRequest {
    private Long productId;
    private int quantity;

    public CreateOrderRequest(Long productId, int quantity) {
        Assert.notNull(productId, "ID 필수");
        Assert.isTrue(quantity > 0, "수량 0보다 커야함");
        this.productId = productId;
        this.quantity = quantity;
    }
}
