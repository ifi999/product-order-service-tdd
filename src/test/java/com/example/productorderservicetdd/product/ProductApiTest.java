package com.example.productorderservicetdd.product;

import com.example.productorderservicetdd.ApiTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.*;

public class ProductApiTest extends ApiTest {

    @Test
    public void 상품등록() {
        final AddProductRequest request = ProductSteps.상품등록요청_생성();

        // API 요
        final ExtractableResponse<Response> response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
