import { useState } from "react";

/* 
버튼을 클릭하면 인풋창에 있는 내용이 오늘의 할일에 등록되는 작업

*/


function StateSample4() {
	/* state 두개 구현해야함. 텍스트 입력시 하나, 등록버튼 클릭시 하나. */
	
	
	let [todo, setTodo] = useState("");
	let [todoList, setTodoList] = useState([]);

	function addTodo(e){
		e.preventDefault();
		setTodoList([...todoList, todo]);
		setTodo("");
	}//화살표함수 안에 바로 넣어도 되긴하는데
	function addTodo2(){
		let list = todoList.slice(0);
		todoList.push(todo);
		setTodoList(todoList);
	}//굳이굳이 push 쓰려면

	return (
		<div>
			<form onSubmit={addTodo}>
				<input type="text" onChange={(e)=>setTodo(e.target.value)} value={todo}/> 
				<button type="submit">등록</button>
			</form>
			<h1>오늘의 할일</h1>
			<ul>
				{
					todoList.map(v=>{
						return <li>{v}</li>
					})
				}
			</ul>
		</div>

	);
}

export default StateSample4;