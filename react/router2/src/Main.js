import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";

function Main(){
	let [data, setData] = useState("");
	const location = useLocation();
	//const res = location.state.res;
	
	useEffect(()=>{
		let isSignup = false;
		if(location.state != null){
			isSignup = location.state.res;
		}
	
		if(isSignup === true){
			alert("회원가입에 성공했습니다.");
			//회원가입 성공 후 새로고침 해도 알림창 안뜨게 하는 코드 (react router에서 location.state를 없애는 공식적인 방법은 x => window.history.replaceState({}, document.title);사용해서 자움
			window.history.replaceState({},document.title);
			//location.state = null;
		}
	}, [location.state]);

	fetch("/api/test")
	.then(res=>res.text())
	.then(res=>setData(res));

	return(
		<div>
			<h1>메인</h1>
			<h2>{data}</h2>
		</div>
	)
}

export default Main;