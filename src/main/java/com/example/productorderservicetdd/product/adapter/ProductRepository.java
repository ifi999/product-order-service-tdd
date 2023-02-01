package com.example.productorderservicetdd.product.adapter;

import com.example.productorderservicetdd.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
