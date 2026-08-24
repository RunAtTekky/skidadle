package com.example.skidadlebackend.services;

import com.example.skidadlebackend.model.GameState;
import com.example.skidadlebackend.model.dto.request.InitRequest;
import com.example.skidadlebackend.model.dto.request.PlaceTileRequest;
import com.example.skidadlebackend.model.dto.response.BoardResponse;
import com.example.skidadlebackend.model.dto.response.GameResponse;
import com.example.skidadlebackend.model.dto.response.InitResponse;
import com.example.skidadlebackend.model.dto.response.UserResponse;

public interface GameService {
  GameResponse placeTile(GameState gameState, PlaceTileRequest placeTileRequest);

  InitResponse initiateGame(GameState gameState, InitRequest initRequest);

  BoardResponse getBoard(GameState gameState);

  UserResponse getUserScore(GameState gameState, int id);
}
