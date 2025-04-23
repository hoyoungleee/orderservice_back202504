package com.playdata.orderservice.common.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogExampleTest {

    @Autowired
    LogExample logExample;

    @Test
    @DisplayName("로그 레벨 확인")
    void logTest() {
        // given: 준비 -> 테스트에 사용할 변수, 입력값 등을 정의하는 곳.

        // when: 실행 -> 테스트를 실행하는 메인 로직
        logExample.showLog();
        // then: 검증 -> 예상한 값, 실제 실행한 값을 확인하는 부분.
    }
}