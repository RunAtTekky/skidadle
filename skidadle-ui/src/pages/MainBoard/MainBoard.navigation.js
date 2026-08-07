export const moveToNextEmptyCell = (
  index,
  rowStep,
  colStep,
  row,
  col,
  boardState,
  inputRefs,
) => {
  let nextRow = Math.floor(index / col) + rowStep;
  let nextCol = (index % col) + colStep;

  while (
    nextRow >= 0 &&
    nextRow < row &&
    nextCol >= 0 &&
    nextCol < col
  ) {
    const nextIndex = nextRow * col + nextCol;

    if (boardState[nextIndex] === "") {
      inputRefs.current[nextIndex]?.focus();
      return;
    }

    nextRow += rowStep;
    nextCol += colStep;
  }
};