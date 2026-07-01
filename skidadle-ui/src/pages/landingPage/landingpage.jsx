import "./landingpage.css";

function LandingPage() {
  return (
    <div className="container">
      <h1 className="title">Skidadle</h1>

      <div className="setup-card">
        <h2 className="card-title">GAME SETUP</h2>

        <div className="divider"></div>

        <div className="input-group">
          <label className="label">Number of Rows</label>

          <input
            type="number"
            className="input"
            defaultValue={10}
            min={5}
            max={20}
          />

          <p className="hint">Min 5 - Max 20</p>
        </div>

        <div className="input-group">
          <label className="label">Number of Columns</label>
          

          <input
            type="number"
            className="input"
            defaultValue={10}
            min={5}
            max={20}
          />

          <p className="hint">Min 5 - Max 20</p>

        </div>
        
        </div>
         <div className="button">
        <button className="btn">Play Offline</button>
        <button className="btn">Play Online</button>
        </div>
       
        </div>
  );
}

export default LandingPage;