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
	<button class="btn btn-outline-success btn-baord" data-num="0">전체</button>
		
	<c:forEach items="${boardList}" var="board">	<!-- items가 화면(model)에 올라간 이름, var가 여기서 하나씩 사용할 속성 이름 --> <!-- 태그라이브러리(맨 위)에 c태그 등록돼있으니 사용 가능 -->
		<button class="btn btn-outline-warning btn-baord" data-num="${board.bo_num}">${board.bo_name}</button>	
	</c:forEach>
	
	<!-- 검색 화면 추가(검색창, 검색타입, 버튼) -->
	
	<!-- 게시글 목록을 보여주는 컨테이너 (비동기통신으로) -->
	<div class = "pl-container">
		
	</div>

	<!-- 페이지네이션x. -->
	<!-- 더보기 버튼을 추가 -->

	<script type="text/javascript">
	//게시판 버튼을 클릭하면 해당 게시판 번호가 alert으로 뜨도록(전체 0 공지 자유 토론 임시 각각 게시판 번호가)
		$(document).off("submit", ".btn-baord")
		$(document).on("submit", ".btn-baord", function(e){
			let num = $(this).data(num);
			alert(num);
		}
	
	
	</script>


</body>
</html>