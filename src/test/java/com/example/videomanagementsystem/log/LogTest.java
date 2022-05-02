package com.example.videomanagementsystem.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest
@Slf4j
@Component
public class LogTest {

    @Test
    public void test1() {
        log.info("test...rocky1996");
    }
}
