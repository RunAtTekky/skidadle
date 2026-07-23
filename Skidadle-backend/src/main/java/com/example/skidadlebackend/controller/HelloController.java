package com.example.skidadlebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String Home() {
        return "Welcome to Skidadle";
    }

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World";
    }
}
