<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<!-- 
	서버에서 보낸 데이터를 처리할 때는 $`{화면에서사용할이름}`(인식돼버려서 역따옴표 넣어둠...)을 이용하여 활용	-> 중괄호 안 띄어쓰기로 여러 변수 구분. 중괄호 안에는 띄어쓰기 없앨것..
		단, 주의사항으로 `$`{}는 주석에서도 인식됨... 주석에서 사용시 조심...
		

 -->


	<P>서버에서 보낸 제 이름은 ${name}.</P>
	<!-- 기존 a href="/spring/어쩌구"을 c:url로 대체 -->

	<a href="<c:url value="?name=abc&age=10"/>">서버로 name과 age 값을 전송</a>
	<br>
	<!-- ? 뒤에 오는건 서버에 보내는 데이터(노출되어도 상관없는) -->
	<a href="<c:url value="/send?name=abc&age=10"/>">서버(/send)로 name과 age 값을 전송</a>
	<!-- send 처리할 컨트롤러 주석 없으면 error 404 발생 -->



	<form action="<c:url value='/send'/>" method="get">
		<h1>form태그를 이용하여 get방식으로 전송</h1>
		<input type="text" name="name" placeholder="이름을 입력하세요."> <br>
		<input type="number" name="age" placeholder="나이를 입력하세요."> <br>
		<button type="submit">전송</button>
	</form>
	<form action="<c:url value='/send'/>" method="post">
		<h1>form태그를 이용하여 post방식으로 전송</h1>
		<input type="text" name="name" placeholder="이름을 입력하세요."> <br>
		<input type="number" name="age" placeholder="나이를 입력하세요."> <br>
		<button type="submit">전송</button>
	</form>
	<h1>url 경로에 데이터 보내기</h1>
	<a href="<c:url value='/홍길동/10'/>">url 경로에 데이터 보내기</a>
	<h1>redirect 예제</h1>
	<a href='/redirect?name=홍길동&age=10'>리다이렉트 예제</a>
	<h1>forward 예제</h1>
	<a href="/forward?name=홍길동&age=10">포워드 예제</a>
	${user}



	<script type="text/javascript">
		// let name = 홍길동;		// (오류)홍길동 문자열이 아니라 변수취급
		let name1 = "${name}";
		let str = `서버에서 보낸 이름은 ${name1} 입니다.`; // 역따옴표 안에 변수 넣을때 js에서도 달러중괄호 사용
		console.log(str); //서버에서 보낸 이름 안 나옴		// 달러 중괄호 둘이 충돌(서버에서 보낸애랑 자바에서 선언한애랑)
		console.log(name1);

		let str2 = `서버에서 보낸 이름은 \${name1} 입니다`; //이렇게 역슬래시 넣어줘야 자바스크립트에서 사용하려는 변수 들어감
		console.log(str2);
		/*
		js 변수 name1을 이용하여 ``안에 변수 값을 넣음
		`` 안에 변수 값을 넣기 위한 달러중괄호와 서버에서 보낸 데이터를 사용하기 위한 달러중괄호가 같기 때문에
		우선순위가 높은 서버에서 봉낸 데이터를 사용하는것으로 인식됨
				==> ``안에서 변수 활용하려면 역슬래시달러중괄호 사용해야
		
				서버에서 보낸 변수 사용할때 유의!
		 */
	</script>
</body>
</html>
