package com.example.skidadlebackend.services;

import com.example.skidadlebackend.model.GameResponse;
import com.example.skidadlebackend.model.GameState;
import com.example.skidadlebackend.model.PlaceTileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameLogic gameLogic;
    private final DictionaryService dictionaryService;

    @Autowired
    public GameService(GameLogic gameLogic, DictionaryService dictionaryService) {
        this.gameLogic = gameLogic;
        this.dictionaryService = dictionaryService;
    }

    public GameResponse placeTile(GameState gameState, PlaceTileRequest placeTileRequest) {
        int id = placeTileRequest.getId();
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
