package com.bluesky.technologies.springboot.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HelloworldSpringBootSmokeTest {

    @Autowired
    private HelloworldSpringBootApplication helloService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(helloService).isNotNull();
    }

}
