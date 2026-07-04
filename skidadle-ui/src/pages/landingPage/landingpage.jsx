import { useState } from "react";
import Button from "../../components/Button/Button";
import TextInput from "../../components/TextInput/TextInput";
import { ACTION_HANDLERS } from "./LandingPage.actionHandlers";
import "./landingpage.css";

function LandingPage() {
  const [row, setRow] = useState(10);
  const [col, setCol] = useState(10);

  const playGame = async () => {
    const data = await ACTION_HANDLERS.PLAY_GAME(row, col);

    if (!data) {
      return;
    }

    console.log("Game initialized:", data);
  };

  return (
    <div className="container">
      <h1 className="title">Skidadle</h1>

      <div className="setup-card">
        <h2 className="card-title">GAME SETUP</h2>

        <div className="divider"></div>

        <TextInput
          label="Number of Rows"
          value={row}
          onChange={(e) => setRow(e.target.value)}
          min={5}
          max={20}
        />

        <TextInput
          label="Number of Columns"
          value={col}
          onChange={(e) => setCol(e.target.value)}
          min={5}
          max={20}
        />
      </div>

      <div className="button">
        <Button onClick={playGame}>Play Offline</Button>
        <Button onClick={playGame}>Play Online</Button>
      </div>
    </div>
  );
}

export default LandingPage;