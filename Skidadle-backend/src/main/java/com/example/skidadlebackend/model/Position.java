package com.example.skidadlebackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Position {
    int row;
    int col;
}
