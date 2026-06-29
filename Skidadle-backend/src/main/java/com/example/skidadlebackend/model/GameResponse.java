package com.example.skidadlebackend.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameResponse {
    private boolean canPlace;
    private CellRange horizontal;
    private CellRange vertical;
    private int score;
    private String error;
}
