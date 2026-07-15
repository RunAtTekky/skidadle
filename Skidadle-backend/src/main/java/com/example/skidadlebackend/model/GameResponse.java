package com.example.skidadlebackend.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GameResponse {
    boolean canPlace;
    Position[] highlightedCells;
    int score;
    String error;
    ResponseStatus status;
}
