package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public String test() {

        logger.info("test");
        return "ok";
    }

    @GetMapping("")
    public String home() {
        logger.info("home");
        return "ok";
    }
}
