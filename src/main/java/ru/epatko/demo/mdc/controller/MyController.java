package ru.epatko.demo.mdc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {

    @GetMapping("/hello")
    public String getHello() {
        log.info("Called getHello");
        return "Hello!";
    }
}
