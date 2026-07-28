import { mainBoardApi } from "./MainBoard.services";

export const placeTileAction = async (payload) => {
  return await mainBoardApi.placeTile(payload);
};

export const getScoreAction = async (id) => {
  return await mainBoardApi.getScore(id);
};