package com.example.productorderservicetdd.order;

import com.example.productorderservicetdd.ApiTest;
import com.example.productorderservicetdd.order.app.service.CreateOrderRequest;
import com.example.productorderservicetdd.product.ProductSteps;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.*;

public class OrderApiTest extends ApiTest {

    @Test
    public void 상품주문() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        CreateOrderRequest request = OrderSteps.상품주문요청_생성();

        ExtractableResponse<Response> response = OrderSteps.상품주문요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
