package com.example.productorderservicetdd.product.app.service;

import com.example.productorderservicetdd.product.app.port.ProductPort;
import com.example.productorderservicetdd.product.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/products")
public class ProductService {

    private final ProductPort productPort;

    public ProductService(final ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequest request) {
        final Product product = new Product(request.getName(), request.getPrice(), request.getDiscountPolicy());

        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // TODO - 만약에 HttpServletRequest 같은 것을 받아서 사용하는데 어떻게 테스트하지??
    // 아래 해결 방법 적었으나, 굳이 구현하지 않음. 추후 프로젝트에 반영해보기
    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable long productId, HttpServletRequest request) {
        Cookie cookie = request.getCookies()[0];
        String name = cookie.getName();
        return getProduct(productId, name);
    }

    // 이렇게 분리해내서 순수 자바로 만들고 테스트
    ResponseEntity<GetProductResponse> getProduct(long productId, String name) {
        final Product product = productPort.getProduct(productId, name);

        GetProductResponse response = new GetProductResponse(
                product.getId()
                , product.getName()
                , product.getPrice()
                , product.getDiscountPolicy());

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{productId}")
    @Transactional
    public ResponseEntity<Void> updateProduct(@PathVariable Long productId, @RequestBody UpdateProductRequest request) {
        Product product = productPort.getProduct(productId);

        product.update(request.getName(), request.getPrice(), request.getDiscountPolicy());

        // TODO - save를 해야하나? 위에서 변경감지로 안끝나는가?
        productPort.save(product);

        return ResponseEntity.ok().build();
    }
}
