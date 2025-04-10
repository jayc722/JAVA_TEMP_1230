import { useState } from "react";
/*

*/




function App3(){
	//let [hobby,setHobby] = useState("");
	let [hobbies, setHobbies] = useState([]);

	function change(e){
		//let target = e.target;
		//console.log(target);

		let {value, checked} = e.target;
		//console.log(value);
		//console.log(name);
		//console.log(checked);

		//checked 된 상태면 배열에 추가
		if(checked) {
			setHobbies([...hobbies, value]);
		}else{
			//아니면 배열에서 제거
			setHobbies(hobbies.filter(v=>v !== value))	// filter : 배열에서 선택한 조건에 맞는 애들만 뽑아서 새로운 배열로 만듦 (value값이 아닌 애들로 새로운 배열 만듦->value를 배열에서 제거)
			/*
			let index = hobbies.indexOf(value);
			let tmp = [...hobbies]
			tmp.splice(index, 1);
			setHobbies(tmp);	*/
			//filter 안쓰면 이렇게 복잡해져버림
		}
		
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
			<h1>{hobbies.join(",")}</h1>	{/* join으로 쉽게 묶을수있음 */}

		</div>
	)
}

export default App3;