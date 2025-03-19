<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<form action="<c:url value="/signup"/>" method="post">
		<h1>회원가입</h1>
		<div class="form-group mt-3">
			<!-- 여기있는 클래스들은 부트스트랩 지원하는 애들. w3s가서 input 가져와도 됨 mb-3은 마진바텀(1~5사이즈) mt-3은 마진탑 -->
			<label for="id" class="form-label">아이디</label> 
			<input type="text" class="form-control" id="id" name="me_id">	<!-- 이런식으로 노출되는게 싫으면 DTO를 따로 만들어야 -->
		</div>

		<div class="form-group mt-3">
			<label for="pw" class="form-label">비밀번호</label> 
			<input type="password" class="form-control" id="pw" name="me_pw">
		</div>

		<div class="form-group mt-3">
			<label for="pw2" class="form-label">비밀번호 확인</label> 
			<input type="password" class="form-control" id="pw2">
		</div>
		
		<div class="form-group mt-3">
			<label for="email" class="form-label">이메일</label> 
			<input type="email"	class="form-control" id="email" name="me_email">
		</div>
		
		<button type = "submit" class="btn btn-outline-sucess mt-3 col-12">회원가입</button>
	</form>

</body>
</html>