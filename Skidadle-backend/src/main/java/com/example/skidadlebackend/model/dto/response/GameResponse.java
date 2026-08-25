package com.example.skidadlebackend.model.dto.response;

import com.example.skidadlebackend.model.Position;
import com.example.skidadlebackend.model.enums.ResponseStatus;
import java.util.List;
import lombok.Builder;

@Builder
public record GameResponse(
    boolean canPlace,
    Position[] highlightedCells,
    int score,
    String error,
    List<String> formedWords,
    ResponseStatus status) {}
