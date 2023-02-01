package com.example.productorderservicetdd.payment;

import org.springframework.stereotype.Component;

public interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);

}
