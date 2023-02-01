package com.example.productorderservicetdd.payment.adapter;

import org.springframework.stereotype.Component;

public interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);

}
