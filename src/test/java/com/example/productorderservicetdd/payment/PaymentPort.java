package com.example.productorderservicetdd.payment;

import com.example.productorderservicetdd.order.Order;

public interface PaymentPort {

    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
