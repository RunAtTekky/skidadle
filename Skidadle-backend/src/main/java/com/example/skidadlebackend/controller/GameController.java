package com.example.skidadlebackend.controller;

import com.example.skidadlebackend.model.GameResponse;
import com.example.skidadlebackend.model.PlaceTileRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skidadle")
public class GameController {
    @GetMapping("/welcome")
    public String hello() {
        final String GAME_NAME = "Skidadle";
        return "Welcome to " + GAME_NAME;
    }

    @PostMapping("/place-tile")
    public GameResponse placeTile(@RequestBody PlaceTileRequest placeTileRequest) {
        // TODO: Give actual placeTile response

        int row = placeTileRequest.getRow();
        int col = placeTileRequest.getCol();
        char ch = placeTileRequest.getCh();

        return GameResponse.builder()
                .status("Success")
                .canPlace(true)
                .horizontal(null)
                .vertical(null)
                .score(row + col)
                .error("")
                .build();
    }

}
