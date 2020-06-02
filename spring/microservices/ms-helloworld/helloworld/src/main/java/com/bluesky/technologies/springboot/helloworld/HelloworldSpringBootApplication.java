package com.bluesky.technologies.springboot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloworldSpringBootApplication {

    /**
     * This class will let Spring to scan the current and underneath package.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(HelloworldSpringBootApplication.class, args);
    }

    /**
     * The helloworld example.
     *
     * @return A simple text saying hello to the world!
     */
    @RequestMapping(value = "/helloworld")
    public String available() {
        return "Hello World";
    }
}
