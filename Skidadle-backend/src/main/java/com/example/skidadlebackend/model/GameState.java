package com.example.skidadlebackend.model;

import lombok.Getter;

@Getter
public class GameState {
    private final Board board;
    private final User user1;
    private final User user2;
    private User currentUserTurn;

    public GameState(int rows, int cols) {
        board = new Board(rows, cols);
        user1 = User.create(board.getId());
        user2 = User.create(board.getId());
        currentUserTurn = user1;
    }

    public void changeTurn() {
        currentUserTurn =  (currentUserTurn == user1) ? user2 : user1;
    }

    public boolean isUserTurn(User candidate) {
        return candidate == currentUserTurn;
    }

    public boolean isUserTurn(int id) {
        return currentUserTurn.getId() == id;
    }
}
