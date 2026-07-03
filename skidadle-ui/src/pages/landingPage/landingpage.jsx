import { useState } from "react";
import Button from "../../components/Button/Button";
import TextInput from "../../components/TextInput/TextInput";
import "./landingpage.css";

function LandingPage() {
  const [row, setRow] = useState(10);
  const [col, setCol] = useState(10);

  const handlePlayOffline = () => {
    console.log("Play Offline button clicked");

    const body = {
      row,
      col,
    };

    console.log("Request Body:", body);

    fetch("http://localhost:8080/api/skidadle/init", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    })
      .then((response) => {
        console.log("Response Status:", response.status);
        return response.json();
      })
      .then((data) => {
        console.log("Response Data:", data);
      })
      .catch((error) => {
        console.error("Fetch Error:", error);
      });
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
          onChange={(e) => setRow(Number(e.target.value))}
          min={5}
          max={20}
        />

        <TextInput
          label="Number of Columns"
          value={col}
          onChange={(e) => setCol(Number(e.target.value))}
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