package com.example.interviewskeleton.controller;

import com.example.interviewskeleton.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet/{name}")
    public String greetUser(
            @PathVariable String name,
            @RequestParam(defaultValue = "en") String locale
    ) {
        return greetingService.generateGreeting(name, locale);
    }
}
