import { useState } from "react";
/*

*/




function App2(){
	let [hobby,setHobby] = useState("");
	function change(e){
		//let target = e.target;
		//console.log(target);

		let {value, name, checked} = e.target;
		//console.log(value);
		//console.log(name);
		//console.log(checked);
		setHobby(value);
	}
	return(
		<div>
			<label>
				<input type="radio" value={"독서"} name="hobby" onClick={change}/> 독서
			</label>
			<label>
				<input type="radio" value={"운동"} name="hobby" onClick={change}/> 운동
			</label>
			<label>
				<input type="radio" value={"음악감상"} name="hobby" onClick={change}/> 음악감상
			</label>
			<label>
				<input type="radio" value={""} name="hobby" onClick={change}/> 해당없음
			</label>
			<h1>{hobby}</h1>

		</div>
	)
}

export default App2;