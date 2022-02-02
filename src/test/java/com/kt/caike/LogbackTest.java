package com.kt.caike;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogbackTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    static void beforeAll() {
        System.out.println("-- @BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("-- @AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("--- @BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("--- @AfterEach");
    }

    @Test
    void test1() {
        System.out.println("---- @Test test1");
    }

    @Test
    void 로그_테스트(){
        logger.debug("[DEBUG]");
        logger.info("[INFO]");
        logger.warn("[WARN]");
        logger.error("[ERROR]");
    }

    @Test
    @Disabled
    void disabled_test() {
        System.out.println("---- @Test disabled_test");
    }
}
