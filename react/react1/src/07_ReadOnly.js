import { useState } from "react";



/* 
읽기 버튼을 클릭하면 인풋창이 읽기 전용으로 변경되고 버튼이 쓰기로 변경 
쓰기 버튼을 클릭하면 인풋창이 쓸수있도록 변경되고 버튼이 일기로 변경
*/


function ReadOnly(){

	let [readOnly, isReadonly] = useState(false);
	let [text, setText] = useState("읽기");

	function toggle(){
		if(!readOnly){
			setText("쓰기");
		}else{
			setText("읽기");
		}
		isReadonly(!readOnly);
	}

	return(
		<div>
			<input readOnly={readOnly}/>

			<button onClick={toggle}>{text}</button>
		</div>

	)
}

export default ReadOnly;