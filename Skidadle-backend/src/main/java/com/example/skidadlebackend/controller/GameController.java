package com.example.skidadlebackend.controller;

import com.example.skidadlebackend.model.*;
import com.example.skidadlebackend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skidadle")
public class GameController {
    private final GameService gameService;
    private GameState gameState;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/welcome")
    public String hello() {
        final String GAME_NAME = "Skidadle";
        return "Welcome to " + GAME_NAME;
    }

    @PostMapping("/init")
    public InitResponse initiateGame(@RequestBody InitRequest initRequest) {
        gameState = new GameState(initRequest.getRow(), initRequest.getCol());

        return gameService.initiateGame(gameState, initRequest);
    }

    @PostMapping("/place-tile")
    public GameResponse placeTile(@RequestBody PlaceTileRequest placeTileRequest) {
        return gameService.placeTile(gameState, placeTileRequest);
    }

    @PostMapping("/board")
    public BoardResponse getBoard() {
        return gameService.getBoard(gameState);
    }

}
