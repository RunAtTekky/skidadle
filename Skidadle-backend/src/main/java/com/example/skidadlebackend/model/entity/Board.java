package com.example.skidadlebackend.model.entity;

import com.example.skidadlebackend.model.Position;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Board {
    private final static char EMPTY_CHAR = '^';
    private final static AtomicInteger idCounter = new AtomicInteger(1);
    private final int id;
    private final int rows;
    private final int cols;
    private final char[][] cells;

    public Board(int rows, int cols) {
        this.id = idCounter.getAndIncrement();
        this.rows = rows;
        this.cols = cols;
        this.cells = new char[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                cells[i][j] = EMPTY_CHAR;
            }
        }
    }

    public boolean isInside(int row, int col) {
        boolean validRow = row >= 0 && row < rows;
        boolean validCol = col >= 0 && col < cols;

        return validRow && validCol;
    }

    public boolean isEmpty(int row, int col) {
        return cells[row][col] == EMPTY_CHAR;
    }

    public char get(int row, int col) {
        return cells[row][col];
    }

    public void set(int row, int col, char ch) {
        cells[row][col] = ch;
    }

    public String getWordFromRange(Position start, Position end) {
        StringBuilder word = new StringBuilder();

        if (start.getRow() == end.getRow()) {
            for (int col=start.getCol(); col<=end.getCol(); col++) {
                char ch = get(start.getRow(), col);
                word.append(ch);
            }
        } else {
            for (int row=start.getRow(); row<=end.getRow(); row++) {
                char ch = get(row, start.getCol());
                word.append(ch);
            }
        }

        return word.toString();
    }
}
