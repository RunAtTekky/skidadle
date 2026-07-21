import { useState } from "react";
import _get from "lodash/get";
import "./MainBoard.css";
import { ACTION_HANDLERS } from "./MainBoard.actionHandlers";
import { CUSTOM_ACTIONS } from "./MainBoard.constants";

const SINGLE_ALPHABET_CHARACTER_REGEX = /^[a-zA-Z]$/;

function getBoardState(board) {
  return _get(board, "cells", [])
    .flatMap((row) => row.split(""))
    .map((cell) => (cell === "^" ? "" : cell));
}

function MainBoard({ board, user1, user2 }) {
  const row = _get(board, "rows", 10);
  const col = _get(board, "cols", 10);

  const boardAreaWidth = window.innerWidth * 0.8;
  const boardAreaHeight = window.innerHeight;

  const cellSize = Math.min(boardAreaWidth / col, boardAreaHeight / row);

  const [boardState, setBoardState] = useState(getBoardState(board));
  const [currentUser, setCurrentUser] = useState(user1);

  return (
    <div className="main-board">
      <div className="board-container">
        <div
          className="board-grid"
          style={{
            width: `${cellSize * col}px`,
            height: `${cellSize * row}px`,
            gridTemplateColumns: `repeat(${col}, ${cellSize}px)`,
            gridTemplateRows: `repeat(${row}, ${cellSize}px)`,
          }}
        >
          {boardState.map((value, index) => (
            <input
              key={index}
              className="board-cell"
              type="text"
              maxLength={1}
              value={value}
              onChange={(e) =>
                ACTION_HANDLERS[CUSTOM_ACTIONS.HANDLE_INPUT_CHANGE](
                  index,
                  e.target.value,
                  col,
                  boardState,
                  setBoardState,
                  currentUser,
                  setCurrentUser,
                  user1,
                  user2,
                )
              }
              onKeyDown={(e) => {
                if (
                  e.key.length === 1 &&
                  !SINGLE_ALPHABET_CHARACTER_REGEX.test(e.key)
                ) {
                  e.preventDefault();
                }
              }}
            />
          ))}
        </div>

        <div className="board-sidebar">
          <h2>POINTS</h2>
        </div>
      </div>
    </div>
  );
}

export default MainBoard;