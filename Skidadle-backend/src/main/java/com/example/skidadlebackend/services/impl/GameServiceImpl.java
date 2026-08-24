package com.example.skidadlebackend.services.impl;

import com.example.skidadlebackend.model.*;
import com.example.skidadlebackend.model.dto.request.InitRequest;
import com.example.skidadlebackend.model.dto.request.PlaceTileRequest;
import com.example.skidadlebackend.model.dto.response.BoardResponse;
import com.example.skidadlebackend.model.dto.response.GameResponse;
import com.example.skidadlebackend.model.dto.response.InitResponse;
import com.example.skidadlebackend.model.dto.response.UserResponse;
import com.example.skidadlebackend.model.entity.User;
import com.example.skidadlebackend.model.enums.ResponseStatus;
import com.example.skidadlebackend.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameLogicImpl gameLogic;

    @Override
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

        Position[] cellsMarked = gameLogic.markCellAndGetHighlightedCells(gameState, row, col, ch);

        gameState.changeTurn();

        return GameResponse.builder()
                .canPlace(true)
                .highlightedCells(cellsMarked)
                .score(cellsMarked.length)
                .error("")
                .status(ResponseStatus.SUCCESS)
                .build();
    }

    @Override
    public InitResponse initiateGame(GameState gameState, InitRequest initRequest) {
        if (!gameLogic.canCreateBoard(initRequest.getRow(), initRequest.getCol())) {
            String errorMsg = String.format("MAX_ROWS = %d, MAX_COLS = %d", GameLogicImpl.MAX_ROWS, GameLogicImpl.MAX_COLS);
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

    @Override
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

    @Override
    public UserResponse getUserScore(GameState gameState, int id) {
        User user = gameState.getUser(id);

        return UserResponse.builder()
                .id(user.getId())
                .boardId(user.getBoardId())
                .score(user.getTotalScore())
                .status(ResponseStatus.SUCCESS)
                .build();
    }
}
