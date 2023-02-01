package com.example.productorderservicetdd.order.adapter;

import com.example.productorderservicetdd.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
