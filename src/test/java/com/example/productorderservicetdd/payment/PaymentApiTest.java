package com.example.productorderservicetdd.payment;

import com.example.productorderservicetdd.ApiTest;
import com.example.productorderservicetdd.order.OrderSteps;
import com.example.productorderservicetdd.product.ProductSteps;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.*;

public class PaymentApiTest extends ApiTest {

    @Test
    public void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());
        PaymentRequest request = PaymentSteps.주문결제요청_생성();

        ExtractableResponse<Response> response = PaymentSteps.주문결제요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
