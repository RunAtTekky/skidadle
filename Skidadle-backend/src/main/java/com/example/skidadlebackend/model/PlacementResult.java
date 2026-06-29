package com.example.skidadlebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlacementResult {
    private boolean canPlace;
    private int scoreGained;

    @Builder.Default
    private List<WordMatch> formedWords = new ArrayList<>();

    @Builder.Default
    private List<String> errors = new ArrayList<>();
}
