const BASE_URL = import.meta.env.VITE_SKIDADLE_API_URL;

export const API = {
  BASE_URL,
  INIT: `${BASE_URL}/init`,
  PLACE_TILE: `${BASE_URL}/place-tile`,
  GET_SCORE: `${BASE_URL}/get-score`
};