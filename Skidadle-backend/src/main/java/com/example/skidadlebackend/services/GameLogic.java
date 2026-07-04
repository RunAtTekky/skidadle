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
        return gs.isUserTurn(id);
    }

    public boolean validateCell(GameState gs, int row, int col, char ch) {
        return gs.getBoard().isInside(row, col) && gs.getBoard().isEmpty(row, col);
    }

    public boolean markCell(GameState gs, int row, int col, char ch) {
        gs.getBoard().set(row, col, ch);

        String horizontalSS = horizontalSearchSpace(gs, row, col, ch);
        String verticalSS = verticalSearchSpace(gs, row, col, ch);

        String largestHorizontalWord = findLargestValidWord(horizontalSS);
        String largestVerticalWord = findLargestValidWord(verticalSS);

        int scoreGained = largestHorizontalWord.length() + largestVerticalWord.length() - 1;
        if (scoreGained == -1) return false;

        gs.getCurrentUserTurn().addScore(scoreGained);
        return true;
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
            while (gs.getBoard().isInside(fixed, starting-1) && !gs.getBoard().isEmpty(fixed, starting-1)) {
                starting--;
            }
        } else {
            while (gs.getBoard().isInside(starting-1, fixed) && !gs.getBoard().isEmpty(starting-1, fixed)) {
                starting--;
            }
        }

        int finishing = variable;
        if (isHorizontal) {
            while (gs.getBoard().isInside(fixed, finishing+1) && !gs.getBoard().isEmpty(fixed, finishing+1)) {
                finishing++;
            }
        } else {
            while (gs.getBoard().isInside(finishing+1, fixed) && !gs.getBoard().isEmpty(finishing+1, fixed)) {
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

    public String findLargestValidWord(String searchSpace) {
        String largestWord = "";

        int n = searchSpace.length();
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                String word = searchSpace.substring(i, j+1);
                if (!dictionaryService.isValidWord(word)) continue;

                int currLength = largestWord.length();
                if (word.length() >= currLength) {
                    largestWord = word;
                }
            }
        }

        return largestWord;
    }

    public boolean canCreateBoard(int row, int col) {
        return row <= MAX_ROWS && col <= MAX_COLS;
    }
}
