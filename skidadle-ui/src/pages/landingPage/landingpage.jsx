import { useState } from "react";
import Button from "../../components/Button/Button";
import TextInput from "../../components/TextInput/TextInput";
import "./landingpage.css";

function LandingPage() {
  const [row, setRow] = useState(10);
  const [col, setCol] = useState(10);

  const handlePlayOffline = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/skidadle/init", {
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

      if (!response.ok) {
        alert(data.error || "Failed to initialize game");
        return;
      }

      if (data.status !== "SUCCESS") {
        alert(data.error || "Game initialization failed");
        return;
      }

      console.log("Game initialized:", data);
    } catch (error) {
      console.error(error);
      alert("Unable to connect to backend");
    }
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
        <Button onClick={handlePlayOffline}>Play Offline</Button>
        <Button>Play Online</Button>
      </div>
    </div>
  );
}

export default LandingPage;
