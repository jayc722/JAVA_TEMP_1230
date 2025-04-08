import { useState } from "react";


/* 미터를 입력해서 변환을 클릭하면 센치미터로 변환되는 코드 작성 */
function Convert(){

	let [amount, setAmount] = useState(0);
	let [res, setRes] = useState("");

	function convert(){
		setRes(amount / 100);
	}

	return(
		<div>
			<div>
				<input type="number" onChange={(e)=>{setAmount(e.target.value)}}/>
				<button onClick={convert}>변환</button>
			</div>
			<input type="number" readOnly value={res} disabled/>
		</div>
	)



}

export default Convert;