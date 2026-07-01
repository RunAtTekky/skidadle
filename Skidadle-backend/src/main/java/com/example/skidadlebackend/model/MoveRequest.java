package com.example.skidadlebackend.model;

import lombok.Data;

@Data
public class MoveRequest {
    private int row;
    private int col;
    private char ch;
}
