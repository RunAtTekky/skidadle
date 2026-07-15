import { API } from "../../constants";

export const mainBoardApi = {
  placeTile: async (payload) => {
    const response = await fetch(API.PLACE_TILE, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(payload),
    });

    const data = await response.json();

    return {
      ok: response.ok,
      ...data,
    };
  },
};