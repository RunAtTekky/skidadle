package com.example.skidadlebackend.services.impl;

import com.example.skidadlebackend.model.*;
import com.example.skidadlebackend.model.entity.Board;
import com.example.skidadlebackend.services.DictionaryService;
import com.example.skidadlebackend.services.GameLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GameLogicImpl implements GameLogic {
    public static final int MAX_ROWS = 20;
    public static final int MAX_COLS = 20;

    private final DictionaryService dictionaryService;

    @Override
    public boolean isUserTurn(GameState gs, int id) {
        return gs.isUserTurn(id);
    }

    @Override
    public boolean validateCell(GameState gs, int row, int col, char ch) {
        return gs.getBoard().isInside(row, col) && gs.getBoard().isEmpty(row, col);
    }

    @Override
    public Position[] markCellAndGetHighlightedCells(GameState gs, int row, int col, char ch) {
        gs.getBoard().set(row, col, ch);

        CellRange horizontalSS = horizontalSearchSpace(gs, row, col, ch);
        CellRange verticalSS = verticalSearchSpace(gs, row, col, ch);

        CellRange largestHorizontalWord = findLargestValidWord(horizontalSS, col);
        CellRange largestVerticalWord = findLargestValidWord(verticalSS, row);

        int scoreGained = largestHorizontalWord.getLength() + largestVerticalWord.getLength() - 1;
        if (scoreGained == -1) scoreGained = 0;

        gs.getCurrentUserTurn().addScore(scoreGained);

        return getMarkedCells(largestHorizontalWord, largestVerticalWord, row, col);
    }

    @Override
    public CellRange horizontalSearchSpace(GameState gs, int row, int col, char ch) {
        return searchSpace(gs, col, row, ch, true);
    }

    @Override
    public CellRange verticalSearchSpace(GameState gs, int row, int col, char ch) {
        return searchSpace(gs, row, col, ch, false);
    }

    private CellRange searchSpace(GameState gs, int variable, int fixed, char ch, boolean isHorizontal) {
        int starting = variable;
        while (isCellOccupied(gs.getBoard(), fixed, starting-1, isHorizontal)) {
            starting--;
        }

        int finishing = variable;
        while (isCellOccupied(gs.getBoard(), fixed, finishing+1, isHorizontal)) {
            finishing++;
        }

        Position start = isHorizontal ? new Position(fixed, starting) : new Position(starting, fixed);
        Position end = isHorizontal ? new Position(fixed, finishing) : new Position(finishing, fixed);

        String text = gs.getBoard().getWordFromRange(start, end);

        return new CellRange(starting, finishing, text);
    }

    @Override
    public CellRange findLargestValidWord(CellRange searchSpace, int fixedPosition) {
        String text = searchSpace.getText();

        CellRange result = new CellRange(0, 0, "");

        int n = text.length();
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                int start = searchSpace.getStart() + i;
                int end = searchSpace.getStart() + j;

                boolean isBetween = start <= fixedPosition && fixedPosition <= end;
                if (!isBetween) continue;

                String word = text.substring(i, j+1);
                if (!dictionaryService.isValidWord(word)) continue;

                int currLength = result.getLength();
                if (word.length() >= currLength) {
                    result = new CellRange(start, end, word);
                }
            }
        }

        return result;
    }

    @Override
    public boolean canCreateBoard(int row, int col) {
        return row <= MAX_ROWS && col <= MAX_COLS;
    }

    // Horizontal - Row stays fixed
    // Vertical - Column stays fixed
    private boolean isCellOccupied(Board board, int fixed, int variable, boolean isHorizontal) {
        if (isHorizontal) {
            return board.isInside(fixed, variable) && !board.isEmpty(fixed, variable);
        } else {
            return board.isInside(variable, fixed) && !board.isEmpty(variable, fixed);
        }
    }

    private Position[] getMarkedCells(CellRange largestHorizontalWord, CellRange largestVerticalWord, int row, int col) {
        Set<Position> markedCells = new HashSet<>();

        for (int j=largestHorizontalWord.getStart(); j<=largestHorizontalWord.getEnd(); j++) {
            markedCells.add(new Position(row, j));
        }

        for (int i=largestVerticalWord.getStart(); i<=largestVerticalWord.getEnd(); i++) {
            markedCells.add(new Position(i, col));
        }

        return markedCells.toArray(new Position[0]);
    }
}
