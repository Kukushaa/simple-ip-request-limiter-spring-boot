package com.example.testspringboot.controller;

import com.example.testspringboot.annotation.IpRateLimit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainRestController.class);

    @IpRateLimit(limit = 5, duration = 60)
    @GetMapping("/protected-resource")
    public ResponseEntity<Object> protectedResource() {
        LOGGER.info("Request rendered successfully");

        return new ResponseEntity<>("Request get successfully", HttpStatus.OK);
    }
}
