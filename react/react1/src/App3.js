import { useState } from "react";
/*

*/




function App3(){
	let [hobby,setHobby] = useState("");

	let [arr,setArr] = useState([]);

	function change(e){
		//let target = e.target;
		//console.log(target);

		let {value, name, checked} = e.target;
		//console.log(value);
		//console.log(name);
		//console.log(checked);

		if(checked) {
			setArr(arr.push(value));
		}else{
			let index = arr.indexOf(value);
			if(index<0)return;
			setArr(arr.splice(index,1));
		}
		
		if(arr.length<1) {
			setHobby("");
			return;
		}
		console.log(arr);

		let text = "";
		arr.forEach(check=>{
			if(text.length==0){text = check;}
			else{text += (", " + check);}
		})

		setHobby(text);
	}
	return(
		<div>
			<label>
				<input type="checkbox" value={"독서"} name="hobby" onClick={change}/> 독서
			</label>
			<label>
				<input type="checkbox" value={"운동"} name="hobby" onClick={change}/> 운동
			</label>
			<label>
				<input type="checkbox" value={"음악감상"} name="hobby" onClick={change}/> 음악감상
			</label>
			<h1>{hobby}</h1>

		</div>
	)
}

export default App3;