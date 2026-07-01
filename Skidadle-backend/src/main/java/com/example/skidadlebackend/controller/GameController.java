package com.example.skidadlebackend.controller;

import com.example.skidadlebackend.model.GameResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skidadle")
public class GameController {
    @GetMapping("/welcome")
    public String hello() {
        final String GAME_NAME = "Skidadle";
        return "Welcome to " + GAME_NAME;
    }

    @GetMapping("/place-tile")
    public GameResponse placeTile() {
        // TODO: Give actual placeTile response
        return GameResponse.builder()
                .status("Success")
                .canPlace(true)
                .horizontal(null)
                .vertical(null)
                .score(0)
                .error("")
                .build();
    }

}
