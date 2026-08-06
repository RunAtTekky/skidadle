import { useRef, useState } from "react";
import { moveToNextEmptyCell } from "./MainBoard.navigation";
import _get from "lodash/get";
import ScoreCard from "../../components/ScoreBoard/ScoreCard";
import "./MainBoard.css";
import { ACTION_HANDLERS } from "./MainBoard.actionHandlers";
import { CUSTOM_ACTIONS } from "./MainBoard.constants";

const SINGLE_ALPHABET_CHARACTER_REGEX = /^[a-zA-Z]$/;

const CELL_GAP = 12;
const BOARD_PADDING = 20;

function getBoardState(board) {
  return _get(board, "cells", [])
    .flatMap((row) => row.split(""))
    .map((cell) => (cell === "^" ? "" : cell));
}

function MainBoard({ board, user1, user2 }) {
  const row = _get(board, "rows", 10);
  const col = _get(board, "cols", 10);

  const boardAreaWidth = window.innerWidth * 0.8 - BOARD_PADDING * 2;
  const boardAreaHeight = window.innerHeight - BOARD_PADDING * 2;

  const cellSize = Math.min(
    (boardAreaWidth - CELL_GAP * (col - 1)) / col,
    (boardAreaHeight - CELL_GAP * (row - 1)) / row,
  );

  const [boardState, setBoardState] = useState(getBoardState(board));
  const [currentUser, setCurrentUser] = useState(user1);
  const [highlightedCells, setHighlightedCells] = useState([]);
  const [scores, setScores] = useState({
    [user1.id]: user1.totalScore,
    [user2.id]: user2.totalScore,
  });
  const inputRefs = useRef([]);

  const isGameOver = boardState.every((cell) => cell !== "");

  const isDraw = isGameOver && scores[user1.id] === scores[user2.id];

  const winnerId =
    isGameOver && !isDraw
      ? scores[user1.id] > scores[user2.id]
        ? user1.id
        : user2.id
      : null;

  return (
    <div className="main-board">
      <div className="board-container">
        <div className="player-score-panel">
          <ScoreCard
            label="Player 1"
            score={scores[user1.id]}
            isActive={currentUser.id === user1.id}
            isWinner={winnerId === user1.id}
            isDraw={isDraw}
          />
        </div>

        <div
          className="board-grid"
          style={{
            gap: `${CELL_GAP}px`,
            padding: `${BOARD_PADDING}px`,
            width: `${cellSize * col + CELL_GAP * (col - 1) + BOARD_PADDING * 2}px`,
            height: `${cellSize * row + CELL_GAP * (row - 1) + BOARD_PADDING * 2}px`,
            gridTemplateColumns: `repeat(${col}, ${cellSize}px)`,
            gridTemplateRows: `repeat(${row}, ${cellSize}px)`,
          }}
        >
          {boardState.map((value, index) => {
            const currentRow = Math.floor(index / col);
            const currentCol = index % col;

            const isHighlighted = highlightedCells.some(
              (cell) => cell.row === currentRow && cell.col === currentCol,
            );

            return (
              <input
                ref={(element) => {
                  inputRefs.current[index] = element;
                }}
                key={index}
                className={`board-cell ${isHighlighted ? "highlighted-cell" : ""}`}
                type="text"
                maxLength={1}
                value={value}
                readOnly={value !== ""}
                onFocus={(e) => {
                  if (value !== "") {
                    e.target.blur();
                  }
                }}
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
                    setHighlightedCells,
                    setScores,
                  )
                }
                onKeyDown={(e) => {
                  switch (e.key) {
                    case "ArrowLeft":
                      e.preventDefault();
                      moveToNextEmptyCell(
                        index,
                        0,
                        -1,
                        row,
                        col,
                        boardState,
                        inputRefs,
                      );
                      return;

                    case "ArrowRight":
                      e.preventDefault();
                      moveToNextEmptyCell(
                        index,
                        0,
                        1,
                        row,
                        col,
                        boardState,
                        inputRefs,
                      );
                      return;

                    case "ArrowUp":
                      e.preventDefault();
                      moveToNextEmptyCell(
                        index,
                        -1,
                        0,
                        row,
                        col,
                        boardState,
                        inputRefs,
                      );
                      return;

                    case "ArrowDown":
                      e.preventDefault();
                      moveToNextEmptyCell(
                        index,
                        1,
                        0,
                        row,
                        col,
                        boardState,
                        inputRefs,
                      );
                      return;

                    default:
                      if (
                        e.key.length === 1 &&
                        !SINGLE_ALPHABET_CHARACTER_REGEX.test(e.key)
                      ) {
                        e.preventDefault();
                      }
                  }
                }}
              />
            );
          })}
        </div>

        <div className="player-score-panel">
          <ScoreCard
            label="Player 2"
            score={scores[user2.id]}
            isActive={currentUser.id === user2.id}
            isWinner={winnerId === user2.id}
            isDraw={isDraw}
          />
        </div>
      </div>
    </div>
  );
}

export default MainBoard;