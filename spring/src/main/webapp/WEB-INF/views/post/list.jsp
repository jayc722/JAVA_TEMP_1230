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
	
	
	<!-- 정렬방식 선택 -->
	<select class="form-control col-3 sel-type">
		<option value="po_num desc">최신순</option>
		<option value="po_up desc">추천순</option>
		<option value="po_view desc">조회순</option>
	</select>
	
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
	<!-- <button class = "btn btn-danger btn-more col-12">더보기</button> -->
	

	<script type="text/javascript">
		let cri = {					// cri를 전역변수로 설정
				po_bo_num : 0,
				page : 1,
				orderBy : "po_num desc"
		}
		//let str = "";
	
	
		//getPostList(cri);			//처음 실행시 전체 선택되게	->처음 정의라 po_bo_num 0으로 돼있음
		let data = getPostList(cri);
		//console.log(data);
		$(".pl-container").html(data);	
	
	
	//게시판 클릭 이벤트
		$(".btn-board").click(function(e){
			//alert(1);
			
			//let num = $(this).data("num");
			cri.po_bo_num = $(this).data("num");
			cri.page = 1; 			//게시판 바뀌면 1페이지로 초기화
			
			let data = getPostList(cri);
			$(".pl-container").html(data);		//1번 페이지 생성

		});

	//더보기 클릭 이벤트
		$(document).on("click", ".btn-more", function(e){
			$(this).remove();
			cri.page = cri.page + 1;
			let data = getPostList(cri);
			//console.log(data);
			$(".pl-container").append(data);			//1번 페이지 뒤에 계속 덧붙여줌			
		});
	
	//정렬방식 change 이벤트
		$(".sel-type").change(function(e){
			cri.orderBy = $(this).val();
			cri.page = 1;
			let data = getPostList(cri);
			$(".pl-container").html(data);
			
		})
	
		
		
		
		
		
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

		//function getPostList(num){
		function getPostList(cri){
			checkBoardBtn(cri.po_bo_num);
			
			//alert(num);
			/*
			비동기 통신으로 서버에 연결하여 빈 문자열을 받는 코드 작성
			url : /post/list
			method : post
			data : num을 전송 -> po_bo_num과 page를 전송
			po_bo_num과 page 번호에 맞는 게시글 목록을 가져오도록 수정
			*/
			let res= '';
			
			//object로 보내고 object로 받는 예제
			$.ajax({
				async : false,		//굳이 동기화 시킬 이유가 x -> 이제 동기화 할 이유가 생김(더보기 버튼 누를때마다 게시글 순서대로 가져와야하므로) 
				url : '<c:url value="/post/list"/>', 
				type : 'post', 
				data : JSON.stringify(cri),				//페이지 우선 임의로 
				contentType : "application/json; charset=utf-8",
				//dataType : "json",
				success : function (data){
					//console.log(data);
	
					//우선 아무 게시판 클릭하면 pl-container에 1 띄우도록
					//let str = `1`;
					res = data;		//data를 문자열로 받아옴
					
					//서버에서 sub.jsp를 가져와서 data로 뿌려줌
					//$(".pl-container").html(str);			//text로 넣어도 되지만 hmtl 이용할 거기 때문에
					
					
				}
			});
			return res;				//여기다 박아야 return 되는구나
		}
		
	</script>


</body>
</html>