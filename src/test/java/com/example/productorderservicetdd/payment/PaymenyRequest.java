package com.example.productorderservicetdd.payment;

import org.springframework.util.Assert;

public class PaymenyRequest {
    private Long orderId;
    private String cardNumber;

    public PaymenyRequest(Long orderId, String cardNumber) {
        Assert.notNull(orderId, "주문 id 필수");
        Assert.notNull(cardNumber, "카드 번호 필수");

        this.orderId = orderId;
        this.cardNumber = cardNumber;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
