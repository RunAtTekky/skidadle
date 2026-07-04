const BASE_URL = "http://localhost:8080/api/skidadle";

export const landingPageApi = {
  initializeGame: async (row, col) => {
    const response = await fetch(`${BASE_URL}/init`, {
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