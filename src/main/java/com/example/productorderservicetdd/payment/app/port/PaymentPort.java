package com.example.productorderservicetdd.payment.app.port;

import com.example.productorderservicetdd.order.domain.Order;
import com.example.productorderservicetdd.payment.domain.Payment;

public interface PaymentPort {

    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
