import { placeTileAction } from "./MainBoard.actions";
import { CUSTOM_ACTIONS } from "./MainBoard.constants";

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

  const updatedBoard = [...boardState];
  updatedBoard[index] = input;
  setBoardState(updatedBoard);

  setCurrentUser(currentUser.id === user1.id ? user2 : user1);
};

export const ACTION_HANDLERS = {
  [CUSTOM_ACTIONS.HANDLE_INPUT_CHANGE]: handleInputChange,
};