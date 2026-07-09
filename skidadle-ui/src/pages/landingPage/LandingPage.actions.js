import { landingPageApi } from "./LandingPage.services";

export const initializeGameAction = async (row, col) => {
  return await landingPageApi.initializeGame(row, col);
};