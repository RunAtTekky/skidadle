package com.example.skidadlebackend.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GameResponse {
    String status;
    boolean canPlace;
    CellRange horizontal;
    CellRange vertical;
    int score;
    String error;
}
