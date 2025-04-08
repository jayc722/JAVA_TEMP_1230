import { useState } from "react";



/* 
읽기 버튼을 클릭하면 인풋창이 읽기 전용으로 변경되고 버튼이 쓰기로 변경 
쓰기 버튼을 클릭하면 인풋창이 쓸수있도록 변경되고 버튼이 일기로 변경
*/


function ReadOnly(){

	let [state, setState] = useState(false);
	

	function read(e){
		e.preventDefault();
		setState(!state);
		
	}

	return(
		<div>
			<input readOnly={state}/>

			<button onClick={(e)=>read(e)} hidden={!state}>쓰기</button>
			<button onClick={(e)=>read(e)} hidden={state}>읽기</button>
		</div>

	)
}

export default ReadOnly;