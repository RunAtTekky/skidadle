import { useState } from "react";
import { useLocation } from "react-router-dom";
import "./MainBoard.css";
import { placeTileAction } from "./MainBoard.actions";

function MainBoard() {
  const { state } = useLocation();

  const boardData = state?.board;
  const user1 = state?.user1;
  const user2 = state?.user2;

  const row = boardData?.rows || 10;
  const col = boardData?.cols || 10;

  const boardAreaWidth = window.innerWidth * 0.8;
  const boardAreaHeight = window.innerHeight;

  const cellSize = Math.min(
    boardAreaWidth / col,
    boardAreaHeight / row
  );

  const [board, setBoard] = useState(
    boardData?.cells
      .flatMap((row) => row.split(""))
      .map((cell) => (cell === "^" ? "" : cell)) ??
      Array.from({ length: row * col }, () => "")
  );

  const [currentUser, setCurrentUser] = useState(user1);

  const handleInputChange = async (index, value) => {
    const input = value.toUpperCase();

    if (input !== "" && !/^[A-Z]$/.test(input)) {
      return;
    }

    if (board[index] !== "") {
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

    const updatedBoard = [...board];
    updatedBoard[index] = input;
    setBoard(updatedBoard);

    setCurrentUser(
      currentUser.id === user1.id ? user2 : user1
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
          {board.map((value, index) => (
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