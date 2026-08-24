package com.example.skidadlebackend.controller;

import com.example.skidadlebackend.model.*;
import com.example.skidadlebackend.model.dto.request.InitRequest;
import com.example.skidadlebackend.model.dto.request.PlaceTileRequest;
import com.example.skidadlebackend.model.dto.response.*;
import com.example.skidadlebackend.model.enums.ResponseStatus;
import com.example.skidadlebackend.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skidadle")
@RequiredArgsConstructor
public class GameController {
  private final GameService gameService;
  private GameState gameState;

  @GetMapping("/welcome")
  public HelloResponse hello() {
    return HelloResponse.builder()
        .greeting("Welcome to Skidadle")
        .status(ResponseStatus.SUCCESS)
        .build();
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

  @GetMapping("/get-score")
  public UserResponse getScore(@RequestParam int id) {
    return gameService.getUserScore(gameState, id);
  }
}
