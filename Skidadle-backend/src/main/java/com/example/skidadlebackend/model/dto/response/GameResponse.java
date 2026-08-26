package com.example.skidadlebackend.model.dto.response;

import com.example.skidadlebackend.model.Position;
import com.example.skidadlebackend.model.enums.ResponseStatus;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class GameResponse {
  boolean canPlace;
  Position[] highlightedCells;
  int score;
  String error;
  List<String> formedWords;
  ResponseStatus status;
}
