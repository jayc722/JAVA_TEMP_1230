import { useState } from "react";


function Signup(){

	let[id, setId] = useState("");
	let[pw, setPw] = useState("");
	let[pw2, setPw2] = useState("");
	let[email, setEmail] = useState("");


	const submit = function (e){
		e.preventDefault();
		console.log(id+pw+pw2+email);
		
	}


	return (

		<div className="container">
			<h1>회원가입</h1>
			<form onSubmit={submit}>
				<div className="mb-3 mt-3">
					<label for="id" className="form-label">아이디:</label>
					<input type="text" className="form-control" id="id" placeholder="아이디를 입력하세요." name="id" onChange={e=>setId(e.target.value)}/>
				</div>
				<div class="mb-3 mt-3">
					<label for="pw" className="form-label">비번:</label>
					<input type="password" className="form-control" id="pw" placeholder="비밀번호를 입력하세요." name="pw" onChange={e=>setPw(e.target.value)}/>
				</div>
				<div class="mb-3 mt-3">
					<label for="pw2" className="form-label">비번확인:</label>
					<input type="password" className="form-control" id="pw2" placeholder="비밀번호를 입력하세요." name="pw2" onChange={e=>setPw2(e.target.value)}/>
				</div>
				<div class="mb-3 mt-3">
					<label for="email" className="form-label">이메일:</label>
					<input type="email" className="form-control" id="email" placeholder="이메일주소를 입력하세요." name="email" onChange={e=>setEmail(e.target.value)}/>
				</div>
				<button className="btn btn-outline-success col-12">회원가입</button>
			</form>
		</div>
	)
}

export default Signup;