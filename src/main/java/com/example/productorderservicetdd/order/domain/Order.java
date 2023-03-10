package com.example.productorderservicetdd.order.domain;

import com.example.productorderservicetdd.product.domain.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    private int quantity;

    public Order(Product product, int quantity) {
        Assert.notNull(product, "상품 필수");
        Assert.isTrue(quantity > 0, "수량 0 이상");

        this.product = product;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return product.getdisCountPrice() * quantity;
    }
}
