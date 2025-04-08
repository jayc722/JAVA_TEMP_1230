import { useState } from "react";

/* 
input 태그에 값을 입력받아 h1태그에 출력하는 작업

*/


function StateSample2() {
	let [text,setText] = useState("");
	//jquery onChange와 약간 다름. 값 입력시마다

	return (
		<div>
			<input type="text" onChange={(e)=>console.log(e.target.value) & setText(e.target.value)}/> 
			<h1>{text}</h1>
		</div>

	);
}

export default StateSample2;