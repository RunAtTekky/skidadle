import "./ScoreCard.css";

const ScoreCard = ({ label, score, isActive, isWinner, isDraw }) => {
  return (
    <div className={`score-card ${isActive ? "score-card-active" : ""}`}>
      <div className="score-card-header">
        <h2>{label}</h2>
        {isWinner && <span className="score-card-status">Winner</span>}
        {isDraw && <span className="score-card-status">Draw</span>}
      </div>
      <p>{score}</p>
    </div>
  );
};

export default ScoreCard;