package com.example.productorderservicetdd.payment;

public class PaymentSteps {
    public static PaymenyRequest 주문결제요청_생성() {
        Long orderId = 1L;
        String cardNumber = "1234-1234-1234-1234";
        return new PaymenyRequest(orderId, cardNumber);
    }
}
