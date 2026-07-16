import { useState } from "react";
import _get from "lodash/get";
import "./MainBoard.css";
import { placeTileAction } from "./MainBoard.actions";

function MainBoard({ board, user1, user2 }) {
  const row = _get(board, "rows", 10);
  const col = _get(board, "cols", 10);

  const boardAreaWidth = window.innerWidth * 0.8;
  const boardAreaHeight = window.innerHeight;

  const cellSize = Math.min(
    boardAreaWidth / col,
    boardAreaHeight / row,
  );

  const [boardState, setBoardState] = useState(
    _get(board, "cells", [])
      .flatMap((row) => row.split(""))
      .map((cell) => (cell === "^" ? "" : cell)),
  );

  const [currentUser, setCurrentUser] = useState(user1);

  const handleInputChange = async (index, value) => {
    const input = value.toUpperCase();

    if (input !== "" && !/^[A-Z]$/.test(input)) {
      return;
    }

    if (boardState[index] !== "") {
      return;
    }

    const currentRow = Math.floor(index / col);
    const currentCol = index % col;

    const response = await placeTileAction({
      id: currentUser.id,
      boardId: currentUser.boardId,
      row: currentRow,
      col: currentCol,
      ch: input,
    });

    if (!response.ok || !response.canPlace) {
      alert(response.error);
      return;
    }

    const updatedBoard = [...boardState];
    updatedBoard[index] = input;
    setBoardState(updatedBoard);

    setCurrentUser(
      currentUser.id === user1.id ? user2 : user1,
    );
  };

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
                handleInputChange(index, e.target.value)
              }
              onKeyDown={(e) => {
                if (
                  e.key.length === 1 &&
                  !/^[a-zA-Z]$/.test(e.key)
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