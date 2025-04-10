import { useState } from "react";


function Signup(){

	let[id, setId] = useState("");
	let[pw, setPw] = useState("");
	let[pw2, setPw2] = useState("");
	let[email, setEmail] = useState("");

	let[data,setData] = useState({
		me_id : '',
		me_pw : '',
		me_pw2 : '',
		me_email : ''
	});

	const submit = function (e){
		e.preventDefault();
		//console.log(id+pw+pw2+email);
		console.log(data);
	}

	const change = e=>{
		setData({
			...data,
			[e.target.name] : e.target.value			//속성의 이름은 대괄호로 넣어줌. 입력된 애의 name값을 value로 넣어줄려고.
		})
	}

	return (

		<div className="container">
			<h1>회원가입</h1>
			<form onSubmit={submit}>
				<div className="mb-3 mt-3">
					<label htmlFor="id" className="form-label">아이디:</label>
					<input type="text" className="form-control" id="id" placeholder="아이디를 입력하세요." name="me_id" /*onChange={e=>setId(e.target.value)}*/onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="pw" className="form-label">비번:</label>
					<input type="password" className="form-control" id="pw" placeholder="비밀번호를 입력하세요." name="me_pw" /*onChange={e=>setPw(e.target.value)}*/onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="pw2" className="form-label">비번확인:</label>
					<input type="password" className="form-control" id="pw2" placeholder="비밀번호를 입력하세요." name="me_pw2" /*onChange={e=>setPw2(e.target.value)}*/onChange={change}/>
				</div>
				<div className="mb-3 mt-3">
					<label htmlFor="email" className="form-label">이메일:</label>
					<input type="email" className="form-control" id="email" placeholder="이메일주소를 입력하세요." name="me_email" /*onChange={e=>setEmail(e.target.value)}*/onChange={change}/>
				</div>
				<button className="btn btn-outline-success col-12">회원가입</button>
			</form>
		</div>
	)
}

export default Signup;