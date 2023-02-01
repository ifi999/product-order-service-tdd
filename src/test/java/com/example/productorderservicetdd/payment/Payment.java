package com.example.productorderservicetdd.payment;

import com.example.productorderservicetdd.order.Order;
import org.springframework.util.Assert;

public class Payment {
    private Long id;
    private Order order;
    private String cardNumber;

    public Payment(Order order, String cardNumber) {
        Assert.notNull(order, "주문 필수");
        Assert.notNull(cardNumber, "카드 번호 필수");

        this.order = order;
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }
}
