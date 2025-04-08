import { useState } from "react";

function Convert3(){

	let [flag, isFlag] = useState(false);
	/*
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
	*/

	let [amount,setAmount] = useState(0);

	return(
		<div>
			<div>
				<input type="number" disabled={flag} onChange={e=>setAmount(e.target.value)} value={!flag?amount : amount / 100}/>
				<button onClick={()=>{isFlag(!flag); setAmount(0);}}>변환</button>
			</div>
			<input type="number" disabled={!flag} value={flag?amount : amount * 100} onChange={e=>setAmount(e.target.value)}/>
		</div>
	)



}

export default Convert3;