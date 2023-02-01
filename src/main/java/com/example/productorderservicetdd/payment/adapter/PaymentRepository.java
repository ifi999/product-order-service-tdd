package com.example.productorderservicetdd.payment.adapter;

import com.example.productorderservicetdd.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PaymentRepository extends JpaRepository<Payment, Long> {

}
