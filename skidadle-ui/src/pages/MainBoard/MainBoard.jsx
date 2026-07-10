import { useState } from "react";
import { useLocation } from "react-router-dom";
import "./MainBoard.css";

function MainBoard() {
  const { state } = useLocation();

  const row = Number(state?.row) || 10;
  const col = Number(state?.col) || 10;

  const boardAreaWidth = window.innerWidth * 0.8;
  const boardAreaHeight = window.innerHeight;

  const cellSize = Math.min(
    boardAreaWidth / col,
    boardAreaHeight / row
  );

  const [board, setBoard] = useState(
    Array.from({ length: row * col }, () => "")
  );

  const handleInputChange = (index, value) => {
    const input = value.toUpperCase();

    if (input !== "" && !/^[A-Z]$/.test(input)) {
      return;
    }

    const updatedBoard = [...board];
    updatedBoard[index] = input;
    setBoard(updatedBoard);
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