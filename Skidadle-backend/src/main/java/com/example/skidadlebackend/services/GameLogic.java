package com.example.skidadlebackend.services;

import com.example.skidadlebackend.model.GameResponse;
import com.example.skidadlebackend.model.GameState;
import org.springframework.stereotype.Service;

@Service
public class GameLogic {
    public boolean validateCell(GameState gs, int row, int col, char ch) {
        return gs.getBoard().isInside(row, col) && gs.getBoard().isEmpty(row, col);
    }

    public void markCell(GameState gs, int row, int col, char ch) {
    }
}
