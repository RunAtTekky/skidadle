import "./TextInput.css";

function TextInput({ label, value, onChange, min, max }) {
  return (
    <div className="input-group">
      <label className="label">{label}</label>

      <input
        type="number"
        className="input"
        value={value}
        onChange={onChange}
        min={min}
        max={max}
      />

      <p className="hint">
        Min {min} - Max {max}
      </p>
    </div>
  );
}

export default TextInput;
