import { useState } from "react";


/* 
m->cm 클릭하면 위 입력창이 쓰기모드로
cm->m 클릭하면 아래 입력창이 쓰기모드로 변환되도록
*/
/* 
m->cm일때 m를 입력하면 cm로 변환하는 코드 08예제 이용해서 작성
*/

function Convert2(){

	let [flag, isFlag] = useState(false);

	let [amount1, setAmount1] = useState(0);
	let [res1, setRes1] = useState(0);

	function convert(){
		if(!flag){
			setRes1(amount1 * 100);
		}else{
			setAmount1(res1 / 100);
		}
	}

	return(
		<div>
			<button onClick={()=>isFlag(false)}>m-&gt;cm</button>
			<button onClick={()=>isFlag(true)}>cm-&gt;m</button>

			<div>
				<input type="number" disabled={flag} onChange={(e)=>{setAmount1(e.target.value)}} value={amount1}/>
				<button onClick={convert}>변환</button>
			</div>
			<input type="number" disabled={!flag} value={res1} onChange={(e)=>{setRes1(e.target.value)}}/>
		</div>
	)



}

export default Convert2;