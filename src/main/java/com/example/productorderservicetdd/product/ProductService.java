package com.example.productorderservicetdd.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
class ProductService {

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

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable long productId) {
        final Product product = productPort.getProduct(productId);

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
