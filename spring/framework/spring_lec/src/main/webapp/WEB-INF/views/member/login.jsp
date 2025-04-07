<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<form action="<c:url value="/login"/>" method="post">	
			<!-- post 방식으로 전송된 메소드 처리할 애가 없으면 405오류 -->
		<h1>로그인</h1>
		<div class="form-group mt-3">
			<!-- 여기있는 클래스들은 부트스트랩 지원하는 애들. w3s가서 input 가져와도 됨 mb-3은 마진바텀(1~5사이즈) mt-3은 마진탑 -->
			<label for="id" class="form-label">아이디</label> 
			<input type="text" class="form-control" id="id" name="me_id">	<!-- 이런식으로 노출되는게 싫으면 DTO를 따로 만들어야 -->
		</div>

		<div class="form-group mt-3">
			<label for="pw" class="form-label">비밀번호</label> 
			<input type="password" class="form-control" id="pw" name="me_pw">
		</div>
		
		<div class="form-check">
			<label for="auto" class="form-check-label"> 
				<input type="checkbox" class="form-check-input" id="auto" name="auto" value="true">자동로그인
			</label>
		</div>

		<button type = "submit" class="btn btn-outline-success mt-3 col-12">로그인</button>
	</form>
	<a href="<c:url value="/find/pw"/>">비번찾기</a>

</body>
</html>