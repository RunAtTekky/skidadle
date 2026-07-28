import _get from "lodash/get";
import { getScoreAction, placeTileAction } from "./MainBoard.actions";
import {
  CUSTOM_ACTIONS,
  HIGHLIGHT_DURATION_MS,
} from "./MainBoard.constants";

const SINGLE_UPPERCASE_LETTER_REGEX = /^[A-Z]$/;

const handleInputChange = async (
  index,
  value,
  col,
  boardState,
  setBoardState,
  currentUser,
  setCurrentUser,
  user1,
  user2,
  setHighlightedCells,
  setScores,
) => {
  const input = value.toUpperCase();

  if (input !== "" && !SINGLE_UPPERCASE_LETTER_REGEX.test(input)) {
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

  const scoreResponse = await getScoreAction(currentUser.id);

  if(scoreResponse.ok){
    setScores((prev) => ({
      ...prev,
      [currentUser.id]: scoreResponse.score,
    }));
  }

  const updatedBoard = [...boardState];
  updatedBoard[index] = input;
  setBoardState(updatedBoard);

  setHighlightedCells(_get(response, "highlightedCells", []));

  setTimeout(() => {
    setHighlightedCells([]);
  }, HIGHLIGHT_DURATION_MS);

  setCurrentUser(currentUser.id === user1.id ? user2 : user1);
};

export const ACTION_HANDLERS = {
  [CUSTOM_ACTIONS.HANDLE_INPUT_CHANGE]: handleInputChange,
};