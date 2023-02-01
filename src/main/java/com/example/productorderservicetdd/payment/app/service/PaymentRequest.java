package com.example.productorderservicetdd.payment.app.service;

import org.springframework.util.Assert;

public class PaymentRequest {
    private Long orderId;
    private String cardNumber;

    public PaymentRequest(Long orderId, String cardNumber) {
        Assert.notNull(orderId, "주문 id 필수");
        Assert.notNull(cardNumber, "카드 번호 필수");

        this.orderId = orderId;
        this.cardNumber = cardNumber;
    }

    public PaymentRequest() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
