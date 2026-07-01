package com.example.skidadlebackend.model;

import lombok.Data;

@Data
public class GameState {
    private final Board board;
    private final User user1;
    private final User user2;
    private boolean isFirstTurn;

    public GameState(int rows, int cols) {
        board = new Board(rows, cols);
        user1 = User.builder().build();
        user2 = User.builder().build();
        isFirstTurn = true;
    }

    public void changeTurn() {
        isFirstTurn = !isFirstTurn;
    }
}
