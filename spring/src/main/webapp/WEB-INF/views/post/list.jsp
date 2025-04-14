<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 class="mt-3">게시글 목록</h1>
	
	<!-- 게시판 버튼 추가 (이거는 웬만해서는 추가 수정 안되니 비동기통신x) -->
	<button class="btn btn-outline-success">전체</button>
		
	<c:forEach items="${boardList}" var="board">	<!-- items가 화면(model)에 올라간 이름, var가 여기서 하나씩 사용할 속성 이름 -->
		<button class="btn btn-outline-warning">${board.bo_name}</button>	
	</c:forEach>
	
	<!-- 검색 화면 추가(검색창, 검색타입, 버튼) -->
	
	<!-- 게시글 목록을 보여주는 컨테이너 (비동기통신으로) -->
	<div class = "pl-container">
		
	</div>

	<!-- 페이지네이션x. -->
	<!-- 더보기 버튼을 추가 -->

	<script type="text/javascript">
	
	
	
	
	</script>


</body>
</html>