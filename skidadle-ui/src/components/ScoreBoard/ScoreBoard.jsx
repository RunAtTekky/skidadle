import "./ScoreBoard.css";

function ScoreBoard({ user1, user2, scores }) {
  return (
    <div className="score-list">
      <div className="score-row">
        <span>Player 1</span>
        <span>{scores[user1.id]}</span>
      </div>
      <div className="score-row">
        <span>Player 2</span>
        <span>{scores[user2.id]}</span>
      </div>
    </div>
  );
}

export default ScoreBoard;
