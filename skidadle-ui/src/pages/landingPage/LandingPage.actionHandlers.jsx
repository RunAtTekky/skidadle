import { initializeGameAction } from "./LandingPage.actions";

export const handlePlayGame = async (row, col) => {
  try {
    const data = await initializeGameAction(row, col);

    if (!data.ok) {
      alert(data.error || "Failed to initialize game");
      return null;
    }

    if (data.status !== "SUCCESS") {
      alert(data.error || "Game initialization failed");
      return null;
    }

    return data;
  } catch (error) {
    console.error(error);
    alert("Unable to connect to backend");
    return null;
  }
};