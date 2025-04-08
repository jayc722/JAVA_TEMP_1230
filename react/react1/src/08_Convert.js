import { useState } from "react";


/* 미터를 입력해서 변환을 클릭하면 센치미터로 변환되는 코드 작성 */
function Convert(){

	let [meter, setMeter] = useState("");
	let [centiMeter, setCentiMeter] = useState("");


	return(
		<div>
			<div>
				<input type="text" onChange={(e)=>{setMeter(e.target.value)}}/>
				<button onClick={(e)=>{setCentiMeter(meter / 100)}}>변환</button>
			</div>
			<input type="text" readOnly value={centiMeter}/>
		</div>
	)



}

export default Convert;