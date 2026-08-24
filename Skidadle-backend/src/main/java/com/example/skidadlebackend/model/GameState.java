package com.example.skidadlebackend.model;

import com.example.skidadlebackend.model.entity.Board;
import com.example.skidadlebackend.model.entity.User;
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
        currentUserTurn = (currentUserTurn == user1) ? user2 : user1;
    }

    public boolean isUserTurn(User candidate) {
        return candidate == currentUserTurn;
    }

    public boolean isUserTurn(int id) {
        return currentUserTurn.getId() == id;
    }

    public User getUser(int id) {
        if (user1.getId() == id) return user1;
        return user2;
    }
}
