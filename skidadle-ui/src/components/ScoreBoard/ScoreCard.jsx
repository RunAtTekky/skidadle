import './ScoreCard.css';

const ScoreCard = ({ label, score, isActive }) => {
  return (
    <div className= {`score-card ${isActive ? "score-card-active" : ""}`} >
      <h2>{label}</h2>
      <p>{score}</p>
    </div>
  )
}

export default ScoreCard;
