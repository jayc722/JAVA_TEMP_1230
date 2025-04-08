import { useState } from "react";

/* 
버튼을 클릭하면 인풋창에 있는 내용이 오늘의 할일에 등록되는 작업

*/


function StateSample4() {
	/* state 두개 구현해야함. 텍스트 입력시 하나, 등록버튼 클릭시 하나. */
	let [text,setText] = useState("");


	let [todo, setTodo] = useState([]);

	return (
		<div>
			<input type="text" id="input" onChange={(e)=>setText(e.target.value)}/> 
			<button  onClick={(e)=>{setTodo([...todo, text]); console.log(text);}}>등록</button>
			<h1>오늘의 할일</h1>
			<ul>
				{
					todo.map((v,i,arr)=>{
						return <li>{v}</li>
					})
				}
			</ul>
		</div>

	);
}

export default StateSample4;