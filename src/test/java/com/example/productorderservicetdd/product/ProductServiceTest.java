package com.example.productorderservicetdd.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

//    @Autowired
    private ProductService productService;
//    private StubProductPort productPort = new StubProductPort();
    private ProductPort productPort;

    @BeforeEach
    void setUp() {
        productPort = Mockito.mock(ProductPort.class);
        productService = new ProductService(productPort);
    }

    // getMapping까지 만들고나서부터는 이 ServiceTest는 필요가 없어진다.
    // 그래서 영상에서는 이 클래스를 삭제해버림

//    @Test
//    public void 상품조회() {
//        // 상품 등록
//        productService.addProduct(ProductSteps.상품등록요청_생성());
//        final long productId = 1L;
//
//        // 상품 조회
//        final GetProductResponse response = productService.getProduct(productId);
//
//        // 상품 응답 검증
//        // 보통 검증을 먼저 만든다고 한다. 내가 생각하던거의 역순
//        assertThat(response).isNotNull();
//    }

    @Test
    public void 상품수정() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        
        // Mockito 때문에 StubProductPort 주석쳐서 여기도 못쓰게 됨
//        productPort.getProduct_will_return = product;
//
//        // Mockito로도 가능하지만 아래의 방법으로도 가능하다
//        productService = new ProductService(productPort);
//
//        productService.updateProduct(productId, request);
//
//        assertThat(product.getName()).isEqualTo("상품 수정");

    }

    @Test
    public void 상품수정_mockito() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        Mockito.when(productPort.getProduct(productId)).thenReturn(product);

        productService.updateProduct(productId, request);

        assertThat(product.getName()).isEqualTo("상품 수정");
    }

//    private static class StubProductPort implements ProductPort {
//        public Product getProduct_will_return;
//
//        @Override
//        public void save(Product product) {
//
//        }
//
//        @Override
//        public Product getProduct(long productId) {
//            return getProduct_will_return;
//        }
//    }
}
