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
	<button class="btn btn-outline-success btn-board" data-num="0">전체</button>
		
	<c:forEach items="${boardList}" var="board">	<!-- items가 화면(model)에 올라간 이름, var가 여기서 하나씩 사용할 속성 이름 --> <!-- 태그라이브러리(맨 위)에 c태그 등록돼있으니 사용 가능 -->
		<button class="btn btn-outline-success btn-board" data-num="${board.bo_num}">${board.bo_name}</button>	
	</c:forEach>
	
	<!-- 검색 화면 추가(검색창, 검색타입, 버튼) -->
	
	<!-- 게시글 목록을 보여주는 컨테이너 (비동기통신으로) -->
	<div class = "pl-container mt-3 mb-3">
		
		<!-- 샘플코드 
		<div class="form-group">
			<div class="form-control input-group" style="min-height : auto; height : auto">
				<img width="100" height="120" alt="" src="https://static.cdn.kmong.com/gigs/2syJC1722251676.jpg">
				<div class="ml-3">
					<div>게시글 제목</div>
					<div>작성자 : 홍길동</div>
					<div>작성일 : 2025-04-14</div>
					<div>조회수 : 100</div>
					<div>추천수 : 10</div>
				
				</div>
			</div>
		</div>
		-->
		
	</div>

	<!-- 페이지네이션x. -->
	<!-- 더보기 버튼을 추가 -->

	<script type="text/javascript">
		getPostList(0);			//처음 실행시 전체 선택되게
	
	
	//게시판 버튼을 클릭하면 해당 게시판 번호가 alert으로 뜨도록(전체 0 공지 자유 토론 임시 각각 게시판 번호가) -> 完
		$(".btn-board").click(function(e){
			//alert(1);
			
			let num = $(this).data("num");

			getPostList(num);

		});
	
		function checkBoardBtn(num){		//일부러 밖에 넣는 이유는 색상같은거 바꾸고 싶을때 여기서 한번에 바꾸면 되게

			//초기 설정
			$(".btn-board").addClass("btn-outline-success");
			$(".btn-board").removeClass("btn-success");
			//num에 따라 게시판 색상을 변경
			$(".btn-board").each(function(){		//반복문으로 num이 같은 녀석을 찾음
				if($(this).data("num") == num){
					$(this).removeClass("btn-outline-success");
					$(this).addClass("btn-success");
				}
			});
	
		}

		function getPostList(num){
			checkBoardBtn(num);
			
			//alert(num);
			/*
			비동기 통신으로 서버에 연결하여 빈 문자열을 받는 코드 작성
			url : /post/list
			method : post
			data : num을 전송
			*/
			//object로 보내고 object로 받는 예제
			$.ajax({
				async : true,		//굳이 동기화 시킬 이유가 x 
				url : '<c:url value="/post/list"/>', 
				type : 'post', 
				//dataType : "json",
				data : {bo_num : num}, 
				//dataType : 서버에서 보낸 데이터의 타입, 
				success : function (data){
					console.log(data);
	
					//우선 아무 게시판 클릭하면 pl-container에 1 띄우도록
					//let str = `1`;
					
					//서버에서 sub.jsp를 가져와서 data로 뿌려줌
					$(".pl-container").html(data);			//text로 넣어도 되지만 hmtl 이용할 거기 때문에
					
					
				}
			});
		}
		
	</script>


</body>
</html>