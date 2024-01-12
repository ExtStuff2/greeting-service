package com.example.greetingservice.controller;

import com.example.greetingservice.domain.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/greeting")
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @GetMapping
    public Greeting getGreeting(
            @RequestParam(required = false, defaultValue = "World") String name,
            @RequestParam(required = false, defaultValue = "World") String surname
    ) {
        log.info("Name: " + name);
        log.info("Surname: " + surname);
        log.info("getGreeting with request param");
        return new Greeting(String.format(TEMPLATE, name));
    }

    @GetMapping("/{name}/{second}")
    public Greeting getGreetingPathVariable(
            @PathVariable String name,
            @PathVariable String second,
            @RequestParam(required = false, defaultValue = "World") String middleName,
            @RequestParam(required = false, defaultValue = "World") String surname
    ) {
        log.info("Name: " + name);
        log.info("Request param 1: " + middleName);
        log.info("Request param 2: " + surname);
        log.info("getGreeting with path variable");
        return new Greeting(String.format(TEMPLATE, name));
    }

}
