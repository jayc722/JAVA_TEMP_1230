import { useState } from "react";
import { useNavigate } from "react-router-dom";


function Signup(){

	const navigate = useNavigate();			//url로 이동시키기

	let[data,setData] = useState({
		me_id : '',
		me_pw : '',
		me_pw2 : '',
		me_email : ''
	});

	const checkRegex = (e) => {
		
		//유효성검사 (기존 유효성검사는 jquery기반이라 여기서 못씀...새롬 만들어야)
		if(data.me_id === ''){
			alert("아이디는 필수 항목입니다.");
			return false;
		} 
		if(data.me_pw === '') {
			alert("비밀번호는 필수 항목입니다.");
			return false;
		}
		if(data.me_pw !== data.me_pw2) {
			alert("비밀번호 확인이 일치하지 않습니다.");
			return false;
		}
		if(data.me_email === '') {
			alert("이메일은 필수 항목입니다.");
			return false;
		}
		//유효성검사 추가하려면 여기다가

		return true;
	}

	const submit = function (e){
		e.preventDefault();
		//console.log(id+pw+pw2+email);
		//console.log(data);

		if(!checkRegex()) return;

		//json으로 비동기통신
		 fetch("api/react/signup",{
			method : "post",
			body : JSON.stringify(data),
			headers : {
				"content-type" : "application/json"
			}
		 })
		 .then(res=>res.json())
		 .then(res=>{
			console.log(res);
			if(res){
				//alert("회원 가입 완료");
				navigate("/",{										//위에서 선언한 navigate
					state : {
						res : res
					} 
				});
			}
			else{
				alert("회원 가입에 실패했습니다.");
				clearData();
			}
		 });

	}

	const change = e=>{
		setData({
			...data,
			[e.target.name] : e.target.value			//속성의 이름은 대괄호로 넣어줌. 입력된 애의 name값을 value로 넣어줄려고.
		})
	}

	const clearData = e =>{
		setData({
			me_id : '', me_pw : '', me_pw2 : '', me_email : ''
		})
	}

	return (

		<div className="container">
			<h1>회원가입</h1>
			<form onSubmit={submit}>
				<div className="mb-3 mt-3">
					<label htmlFor="id" className="form-label">아이디:</label>
					<input type="text" className="form-control" id="id" placeholder="아이디를 입력하세요." name="me_id" value={data.me_id} /*onChange={e=>setId(e.target.value)}*/onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="pw" className="form-label">비번:</label>
					<input type="password" className="form-control" id="pw" placeholder="비밀번호를 입력하세요." name="me_pw" value={data.me_pw} /*onChange={e=>setPw(e.target.value)}*/onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="pw2" className="form-label">비번확인:</label>
					<input type="password" className="form-control" id="pw2" placeholder="비밀번호를 입력하세요." name="me_pw2" value={data.me_pw2} /*onChange={e=>setPw2(e.target.value)}*/onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="email" className="form-label">이메일:</label>
					<input type="email" className="form-control" id="email" placeholder="이메일주소를 입력하세요." name="me_email" value={data.me_email} /*onChange={e=>setEmail(e.target.value)}*/onChange={change}/>
				</div>
				<button className="btn btn-outline-success col-12">회원가입</button>
			</form>
		</div>
	)
}

export default Signup;