package com.example.skidadlebackend.model;

import lombok.Value;

@Value
public class PlaceTileRequest {
    int row;
    int col;
    char ch;
}
