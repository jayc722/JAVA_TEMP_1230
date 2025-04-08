import { useState } from "react";

/* 
버튼을 클릭하면 인풋창에 있는 내용이 h1 태그 안에 들어가도록

*/


function StateSample3() {
	/* state 두개 구현해야함. 텍스트 입력시 하나, 등록버튼 클릭시 하나. */
	let [text,setText] = useState("");

	let [input, setInput] = useState("");

	return (
		<div>
			<input type="text" id="inputText" onChange={(e)=>setInput(e.target.value)}/> 
			<button  onClick={(e)=>setText(input)}>등록</button>
			<h1>{text}</h1>
		</div>

	);
}

export default StateSample3;