package com.bluesky.technologies.springboot.profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ProfilesSpringBootApplication implements CommandLineRunner {

    @Value("${messages.message}")
    private String message;

    @Autowired
    private MessageProperties messageProperties;

    @Override
    public void run(String... args) {
        System.out.println(messageProperties);
    }
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
    @RequestMapping(value = "/messenger")
    public String available() {
        return message;
    }
}
