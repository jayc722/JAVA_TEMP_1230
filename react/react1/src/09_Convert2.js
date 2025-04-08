import { useState } from "react";


/* 
m->cm 클릭하면 위 입력창이 쓰기모드로
cm->m 클릭하면 아래 입력창이 쓰기모드로 변환되도록
*/
function Convert2(){

	let [state, isState] = useState(false);

	function mcm(){
		if(state) isState(false);

	}
	function cmm(){
		if(!state) isState(true);
	}

	return(
		<div>
			<button onClick={mcm}>m-&gt;cm</button>
			<button onClick={cmm}>cm-&gt;m</button>

			<div>
				<input type="number" disabled={state}/>
				<button>변환</button>
			</div>
			<input type="number" disabled={!state}/>
		</div>
	)



}

export default Convert2;