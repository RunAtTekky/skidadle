package com.example.skidadlebackend.services;

import com.example.skidadlebackend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameLogic {
    public static final int MAX_ROWS = 20;
    public static final int MAX_COLS = 20;

    DictionaryService dictionaryService;

    @Autowired
    public GameLogic(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    public boolean isUserTurn(GameState gs, int id) {
        if (gs.getUser1().getId() == id) {
            return gs.isFirstTurn();
        } else {
            return !gs.isFirstTurn();
        }
    }

    public boolean validateCell(GameState gs, int row, int col, char ch) {
        return gs.getBoard().isInside(row, col) && gs.getBoard().isEmpty(row, col);
    }

    public void markCell(GameState gs, int row, int col, char ch) {
        gs.getBoard().set(row, col, ch);
    }

    public String horizontalSearchSpace(GameState gs, int row, int col, char ch) {
        return searchSpace(gs, col, row, ch, true);
    }

    public String verticalSearchSpace(GameState gs, int row, int col, char ch) {
        return searchSpace(gs, row, col, ch, false);
    }

    private String searchSpace(GameState gs, int variable, int fixed, char ch, boolean isHorizontal) {
        int starting = variable;

        if (isHorizontal) {
            while (gs.getBoard().isInside(fixed, variable) && !gs.getBoard().isEmpty(fixed, variable)) {
                starting--;
            }
        } else {
            while (gs.getBoard().isInside(variable, fixed) && !gs.getBoard().isEmpty(variable, fixed)) {
                starting--;
            }
        }

        int finishing = variable;
        if (isHorizontal) {
            while (gs.getBoard().isInside(fixed, variable) && !gs.getBoard().isEmpty(fixed, variable)) {
                finishing++;
            }
        } else {
            while (gs.getBoard().isInside(variable, fixed) && !gs.getBoard().isEmpty(variable, fixed)) {
                finishing++;
            }
        }

        Position start;
        Position end;

        if (isHorizontal) {
            start = new Position(fixed, starting);
            end = new Position(fixed, finishing);
        } else {
            start = new Position(starting, fixed);
            end = new Position(finishing, fixed);
        }

        return gs.getBoard().getWordFromRange(start, end);
    }

    public CellRange findLargestValidWord(String searchSpace, int pivot) {
        CellRange cellRange = new CellRange(0, 0);

        int n = searchSpace.length();
        for (int i=0; i<=pivot; i++) {
            for (int j=pivot; j<n; j++) {
                String word = searchSpace.substring(i, j);
                if (!dictionaryService.isValidWord(word)) continue;

                int currLength = cellRange.getEnd() - cellRange.getStart();
                if (word.length() >= currLength) {
                    cellRange = new CellRange(i, j);
                }
            }
        }

        return cellRange;
    }

    public boolean canCreateBoard(int row, int col) {
        return row <= MAX_ROWS && col <= MAX_COLS;
    }
}
