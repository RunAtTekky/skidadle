package com.example.skidadlebackend.model.dto.request;

import lombok.Value;

@Value
public class PlaceTileRequest {
  int id;
  int boardId;
  int row;
  int col;
  char ch;
}
