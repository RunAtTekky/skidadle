const BASE_URL = import.meta.env.VITE_API_BASE_URL;

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