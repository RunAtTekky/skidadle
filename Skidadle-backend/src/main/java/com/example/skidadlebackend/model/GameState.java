package com.example.skidadlebackend.model;

import lombok.Data;

@Data
public class GameState {
    private final Board board;
    private int totalScore;

    public GameState(int rows, int cols) {
        board = new Board(rows, cols);
        this.totalScore = 0;
    }
}
