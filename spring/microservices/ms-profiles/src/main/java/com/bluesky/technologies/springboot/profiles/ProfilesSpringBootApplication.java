package com.bluesky.technologies.springboot.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProfilesSpringBootApplication {

    @Value("${spring.profiles.dev.message}")
    private String message;

    /**
     * This class will let Spring to scan the current and underneath package.
     *
     * @param args Arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(com.bluesky.technologies.springboot.profiles.ProfilesSpringBootApplication.class, args);
    }

    /**
     * The helloworld example.
     *
     * @return A simple text saying hello to the world!
     */
    @RequestMapping(value = "/messanger")
    public String available() {
        return message;
    }
}
