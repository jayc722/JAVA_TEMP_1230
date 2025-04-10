import { useState } from "react";
/*

*/




function App2(){
	let [state,setState] = useState("");
	function checked(){
		
	}
	return(
		<div>
			<label>
				<input type="radio" value={"독서"} name="hobby" onClick={(e)=>{setState(e.currentTarget.value)}}/> 독서
			</label>
			<label>
				<input type="radio" value={"운동"} name="hobby" onClick={(e)=>{setState(e.currentTarget.value)}}/> 운동
			</label>
			<label>
				<input type="radio" value={"음악감상"} name="hobby" onClick={(e)=>{setState(e.currentTarget.value)}}/> 음악감상
			</label>
			<label>
				<input type="radio" value={""} name="hobby" onClick={(e)=>{setState(e.currentTarget.value)}}/> 해당없음
			</label>
			<h1>{state}</h1>

		</div>
	)
}

export default App2;