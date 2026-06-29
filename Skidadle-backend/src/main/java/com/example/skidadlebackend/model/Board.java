package com.example.skidadlebackend.model;

import lombok.Getter;

@Getter
public class Board {
    private final int rows;
    private final int cols;
    private final char[][] cells;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new char[rows][cols];
    }

    public boolean isInside(int row, int col) {
        boolean validRow = row >= 0 && row < rows;
        boolean validCol = col >= 0 && col < cols;

        return validRow && validCol;
    }

    public boolean isEmpty(int row, int col) {
        return cells[row][col] == '\0';
    }

    public char get(int row, int col) {
        return cells[row][col];
    }

    public void set(int row, int col, char ch) {
        cells[row][col] = ch;
    }
}
