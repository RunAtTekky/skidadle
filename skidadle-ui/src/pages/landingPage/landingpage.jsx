import Button from "../../components/Button/Button";
import TextInput from "../../components/TextInput/TextInput";
import "./landingpage.css";

function LandingPage() {
  return (
    <div className="container">
      <h1 className="title">Skidadle</h1>

      <div className="setup-card">
        <h2 className="card-title">GAME SETUP</h2>

        <div className="divider"></div>

        <TextInput label="Number of Rows" defaultValue={10} min={5} max={20} />

        <TextInput
          label="Number of Columns"
          defaultValue={10}
          min={5}
          max={20}
        />
      </div>
      <div className="button">
        <Button>Play Offline</Button>
        <Button>Play Online</Button>
      </div>
    </div>
  );
}

export default LandingPage;
