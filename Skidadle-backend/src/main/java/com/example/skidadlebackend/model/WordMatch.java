package com.example.skidadlebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordMatch {
    private String word;
    private Direction direction;
    private Position start;
    private Position end;
    private int score;
}
