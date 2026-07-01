import "./TextInput.css";
function TextInput({label, defaultValue, min, max}){
    return (
        <div className = "input-group">
            <label className = "label">{label}</label>
            <input
            type = "number"
            className = "input"
            defaultValue={defaultValue}
            min = {min}
            max = {max}
            />
            <p className = "hint">
                Min {min} - Max {max}
                
                 </p>
        </div>
    )
}
export default TextInput;