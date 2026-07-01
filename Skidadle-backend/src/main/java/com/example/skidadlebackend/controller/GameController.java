package com.example.skidadlebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skidadle")
public class GameController {
    @GetMapping("/welcome")
    public String hello() {
        final String GAME_NAME = "Skidadle";
        return "Welcome to " + GAME_NAME;
    }

}
