package com.example.skidadlebackend.services;

import com.example.skidadlebackend.model.CellRange;
import com.example.skidadlebackend.model.GameState;
import com.example.skidadlebackend.model.Position;

public interface GameLogic {
  boolean isUserTurn(GameState gs, int id);

  boolean validateCell(GameState gs, int row, int col, char ch);

  Position[] markCellAndGetHighlightedCells(GameState gs, int row, int col, char ch);

  CellRange horizontalSearchSpace(GameState gs, int row, int col, char ch);

  CellRange verticalSearchSpace(GameState gs, int row, int col, char ch);

  CellRange findLargestValidWord(CellRange searchSpace, int fixedPosition);

  boolean canCreateBoard(int row, int col);
}
