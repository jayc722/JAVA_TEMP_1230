import { Button } from "./Button";
import { useState } from "react";

function StateSample(){
	let [page, setPage] = useState(1);	//초기값 1		//state 변수 이용하면 바뀐 state만 렌더링 다시
	const maxPage = 6;			//변수는 {}로 가져옴 
	//let page = 1;				//state변수가 아니라 변수로 지정하면 page 값이 증가해도 렌더링이 안돼서 화면에 출력은 안됨
												//state변수는 값이 변경 -> 자동으로 렌더링
	function decrease(){	//onClick 이벤트로 화살표함수나 함수명을 호출
		//alert(1);		
		//page = page - 1; 					//이걸로는 렌더링x
		//setPage( page - 1 );			//state값 바꾸는 setter 이용해야 값 바꾸고 렌더링까지 새로 해줌
		page = page + (-1);
		if(page<1) page = maxPage;
		setPage(page);
		//console.log(page);
	}	//함수 표현식

	const increase = function(){
		page = page + (1);
		if(page>maxPage) page = 1;
		setPage(page);
	}	//함수 선언문

	function add(amount){
		page = page + amount;
		if(page < 1) page = maxPage;
		if(page > maxPage) page = 1;
		setPage(page);
	}

	return(
		<div>
			{/* {<Button text={"-"} click={decrease}/>} */}
			<Button text={"-"} click={()=>add(-1)} />
				<span>{page}</span>

				<span>/{maxPage}</span>			
			<Button text={"+"} click={()=>add(1)} />

			{/* {<Button text={"+"} click={increase}/>} */}
		</div>

	);	
}

export default StateSample;