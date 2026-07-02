package com.example.skidadlebackend.controller;

import com.example.skidadlebackend.model.GameResponse;
import com.example.skidadlebackend.model.GameState;
import com.example.skidadlebackend.model.PlaceTileRequest;
import com.example.skidadlebackend.services.GameLogic;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skidadle")
public class GameController {
    GameState gameState = new GameState(10, 10);

    @GetMapping("/welcome")
    public String hello() {
        final String GAME_NAME = "Skidadle";
        return "Welcome to " + GAME_NAME;
    }

    @PostMapping("/place-tile")
    public GameResponse placeTile(@RequestBody PlaceTileRequest placeTileRequest) {
        // TODO: Give actual placeTile response

        int id = placeTileRequest.getId();;
        int row = placeTileRequest.getRow();
        int col = placeTileRequest.getCol();
        char ch = placeTileRequest.getCh();

        if (!GameLogic.isUserTurn(gameState, id)) {
            return GameResponse.builder()
                    .status("Failure")
                    .error("Not users turn")
                    .build();
        }

        boolean isValid = GameLogic.validateCell(gameState, row, col, ch);

        if (!isValid) {
            return GameResponse.builder()
                    .status("Failure")
                    .canPlace(false)
                    .error("Invalid cell")
                    .build();
        }

        GameLogic.markCell(gameState, row, col, ch);

        return GameResponse.builder()
                .status("Success")
                .canPlace(true)
                .horizontal(null)
                .vertical(null)
                .score(1)
                .error("")
                .build();
    }

}
