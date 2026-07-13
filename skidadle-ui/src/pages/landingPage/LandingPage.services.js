import { API } from "../../constants";

export const landingPageApi = {
  initializeGame: async (row, col) => {
    const response = await fetch(`${API.BASE_URL}${API.INIT}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        row: Number(row),
        col: Number(col),
      }),
    });

    const data = await response.json();

    return {
      ok: response.ok,
      ...data,
    };
  },
};
