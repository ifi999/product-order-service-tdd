package com.example.productorderservicetdd.payment;

public interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);

}
