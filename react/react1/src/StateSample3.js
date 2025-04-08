import { useState } from "react";

/* 
버튼을 클릭하면 인풋창에 있는 내용이 h1 태그 안에 들어가도록

*/


function StateSample3() {
	/* state 두개 구현해야함. 텍스트 입력시 하나, 등록버튼 클릭시 하나. */
	let [text,setText] = useState("");

	let [result, setResult] = useState("출력할 내용을 입력하세요.");

	return (
		<div>
			<input type="text" onChange={(e)=>setText(e.target.value)}/> 
			<button  onClick={(e)=>setResult(text)}>등록</button>
			<h1>{result}</h1>
		</div>

	);
}

export default StateSample3;