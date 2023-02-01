package com.example.productorderservicetdd.payment;

import com.example.productorderservicetdd.order.Order;

public class PaymentService {
    private final PaymentPort paymentPort;

    public PaymentService(PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void payment(PaymenyRequest request) {
        Order order = paymentPort.getOrder(request.getOrderId());

        Payment payment = new Payment(order, request.getCardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);
    }
}
