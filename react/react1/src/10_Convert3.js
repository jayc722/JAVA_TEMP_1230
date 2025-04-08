import { useState } from "react";

function Convert3(){

	let [flag, isFlag] = useState(false);

	let [amount1, setAmount1] = useState(0);
	let [res1, setRes1] = useState(0);

	function mToCm(e){
		setAmount1(e.target.value);
		setRes1(e.target.value * 100);
	}

	function cmToM(e){
		setRes1(e.target.value);
		setAmount1(e.target.value / 100);
	}
	function convert(e){
		var value = e.target.value;
		if(flag){
			setRes1(value);
			setAmount1(value / 100);
		} else {
			setRes1(value * 100);
			setAmount1(value);
		}
	}

	return(
		<div>
			<div>
				<input type="number" disabled={flag} onChange={convert} value={amount1}/>
				<button onClick={()=>isFlag(!flag)}>변환</button>
			</div>
			<input type="number" disabled={!flag} value={res1} onChange={convert}/>
		</div>
	)



}

export default Convert3;