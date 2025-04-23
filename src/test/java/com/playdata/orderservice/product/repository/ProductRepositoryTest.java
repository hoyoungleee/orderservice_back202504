package com.playdata.orderservice.product.repository;

import com.playdata.orderservice.product.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("")
    void bulkInsert() {
        // given: 준비 -> 테스트에 사용할 변수, 입력값 등을 정의하는 곳.
        for (int i = 0; i <= 50; i++) {
            Product build = Product.builder()
                    .name("Product " + i)
                    .category("Category " + i)
                    .price(i * 100)
                    .imagePath("sdfsdf" + i)
                    .build();
            productRepository.save(build);
        }
        // when: 실행 -> 테스트를 실행하는 메인 로직

        // then: 검증 -> 예상한 값, 실제 실행한 값을 확인하는 부분.
    }

}