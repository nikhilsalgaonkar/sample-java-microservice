package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello from Sample Microservice! Current time: " + LocalDateTime.now();
    }

    @GetMapping("/health")
    public String health() {
        return "Service is healthy!";
    }
}
