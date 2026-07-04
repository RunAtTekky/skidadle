package com.example.skidadlebackend.services;

import com.example.skidadlebackend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameLogic gameLogic;

    @Autowired
    public GameService(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public GameResponse placeTile(GameState gameState, PlaceTileRequest placeTileRequest) {
        int id = placeTileRequest.getId();
        int row = placeTileRequest.getRow();
        int col = placeTileRequest.getCol();
        char ch = placeTileRequest.getCh();

        if (!gameLogic.isUserTurn(gameState, id)) {
            return GameResponse.builder()
                    .error("Not users turn")
                    .status(ResponseStatus.ERROR)
                    .build();
        }

        boolean isValid = gameLogic.validateCell(gameState, row, col, ch);

        if (!isValid) {
            return GameResponse.builder()
                    .canPlace(false)
                    .error("Invalid cell")
                    .status(ResponseStatus.ERROR)
                    .build();
        }

        boolean cellMarked = gameLogic.markCell(gameState, row, col, ch);
        if (!cellMarked) {
            return GameResponse.builder()
                    .canPlace(false)
                    .error("No such word exists")
                    .status(ResponseStatus.ERROR)
                    .build();
        }

        gameState.changeTurn();

        return GameResponse.builder()
                .canPlace(true)
                .horizontal(null)
                .vertical(null)
                .score(1)
                .error("")
                .status(ResponseStatus.SUCCESS)
                .build();
    }

    public InitResponse initiateGame(GameState gameState, InitRequest initRequest) {
        if (!gameLogic.canCreateBoard(initRequest.getRow(), initRequest.getCol())) {
            String errorMsg = String.format("MAX_ROWS = %d, MAX_COLS = %d", GameLogic.MAX_ROWS, GameLogic.MAX_COLS);
            return InitResponse.builder()
                    .error(errorMsg)
                    .status(ResponseStatus.ERROR)
                    .build();
        }

        return InitResponse.builder()
                .board(gameState.getBoard())
                .user1(gameState.getUser1())
                .user2(gameState.getUser2())
                .status(ResponseStatus.SUCCESS)
                .build();
    }

    public BoardResponse getBoard(GameState gameState) {
        if (gameState == null) {
            return BoardResponse
                    .builder()
                    .error("Game has not been initialized. Cannot return board.")
                    .status(ResponseStatus.ERROR)
                    .build();
        }

        return BoardResponse
                .builder()
                .board(gameState.getBoard())
                .status(ResponseStatus.SUCCESS)
                .build();
    }

    public UserResponse getUserScore(GameState gameState, int id) {
        User user = gameState.getUser(id);

        return UserResponse.builder()
                .id(user.getId())
                .boardId(user.getBoardId())
                .score(user.getTotalScore())
                .build();
    }
}
