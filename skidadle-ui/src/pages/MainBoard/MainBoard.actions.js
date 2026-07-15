import { mainBoardApi } from "./MainBoard.services";

export const placeTileAction = async (payload) => {
  return await mainBoardApi.placeTile(payload);
};