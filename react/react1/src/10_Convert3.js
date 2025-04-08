import { useState } from "react";

function Convert3(){

	let [flag, isFlag] = useState(false);

	let [amount1, setAmount1] = useState(0);
	let [res1, setRes1] = useState(0);

	return(
		<div>
			<div>
				<input type="number" disabled={flag} onChange={(e)=>{setAmount1(e.target.value); setRes1(amount1 * 100);}} value={amount1}/>
				<button onClick={()=>isFlag(!flag)}>변환</button>
			</div>
			<input type="number" disabled={!flag} value={res1} onChange={(e)=>{setRes1(e.target.value); setAmount1(res1 / 100)}}/>
		</div>
	)



}

export default Convert3;