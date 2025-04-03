<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.js"></script>
</head>

<body>
	<c:choose>
		<c:when test="${post ne null}">
		<h1>게시글 상세</h1>
		
	
		<div class="form-group mt-3">
			<label class="form-label">게시판</label> 
			<input type="text" class="form-control" value="${post.po_bo_name}" readonly>	<!-- 보낼거 아니기때문에 name 불필요 -->
		</div>

		<div class="form-group mt-3">
			<label class="form-label">제목</label> 
			<input type="text" class="form-control" value="${post.po_title}" readonly>	
		</div>

		<div class="form-group mt-3">
			<label class="form-label">작성자</label> 
			<input type="text" class="form-control" value="${post.po_me_id}" readonly>	
		</div>

		<div class="form-group mt-3">
			<label class="form-label">작성일</label> 
			<input type="text" class="form-control" value="<fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss" />" readonly>	
		</div>
		

		<div class="form-group mt-3">
			<label class="form-label">조회수</label> 
			<input type="text" class="form-control" value="${post.po_view}" readonly>	
		</div>
		<div class="form-group mt-3 d-flex justify-content-center">
			<button class="btn btn-outline-success btn-up" data-state="1">추천(${post.po_up})</button>
			<button class="btn btn-outline-danger ml-3 btn-down" data-state="-1">비추천(${post.po_down})</button>	<!-- 추천 비추천 한번에 처리하려고!! -->
		</div>

		<div class="form-group mt-3">
			<label class="form-label">내용</label> 
			<div class="form-control" id="content" style="min-height: 400px;">${post.po_content}</div>
		</div>
		<c:if test="${list.size() ne 0}">
			<div class="form-group">
				<label>첨부파일</label>
				<c:forEach items="${list }" var="file">
					<a class="form-control" href="<c:url value="/download${file.fi_name}"/>" download="${file.fi_ori_name}">${file.fi_ori_name }</a>
																									<!-- 여기서 다운로드 받은 파일의 기본파일이름 설정 -->						
				</c:forEach>							
			</div>
		</c:if>
			</c:when>
		<c:otherwise>
			<h1>등록되지 않거나 삭제된 게시글입니다.</h1>
		</c:otherwise>
	</c:choose>
		
	<div class="d-flex justify-content-between">	<!-- display flex 이용해서 목록 수정 삭제 뒤쪽에 붙이려고 -->
		<a href="<c:url value="/post/list"/>" class="btn btn-outline-success">목록으로 돌아가기</a>
		<c:if test="${user.me_id eq post.po_me_id}">
			<div class="btns">
				<a href="<c:url value="/post/update/${post.po_num}"/>" class="btn btn-outline-info">수정</a>
				<a href="<c:url value="/post/delete/${post.po_num}"/>" class="btn btn-outline-danger">삭제</a>
			</div>
		</c:if>
	</div>
	<hr>
	<h3>댓글</h3>
	<div class="comment-container">
	
	
	
<!--		<div class="comment-list">
			 <div class="comment-item form-control mb-3" style="min-height: auto; height: auto;">
				<div class="comment-wrap">
					<div class="comment-writer">ad</div>
					<div class="comment-content">댓글입니다.</div>
				</div>
				<div class="comment-func mt-2">
					<button class="btn btn-outline-success">대댓</button>
					<button class="btn btn-outline-warning">수정</button>
					<button class="btn btn-outline-danger">삭제</button>
				</div> 
			</div> 
		</div>
		<div class="comment-pagination">
		
		</div>
		
		<div class="comment-insert-box">
			<form class="input-group mb-3 insert-form" action="<c:url value="/comment/insert"/>" method="post">
				<input type="hidden" name="co_po_num" value="${post.po_num}">
			    <textarea rows="" cols="" class="form-control" name="co_content"></textarea>
				<button class="btn btn-outline-success">댓글 등록</button>				    
			</form>
		</div>
		
	</div>
	 -->

	</div>
	
	<!-- 추천 비추천 버튼 클릭 이벤트 등록 -->
	<script type="text/javascript">
		$(".btn-up, .btn-down").click(function(e){					// 선택자는 ,가 or의 의미
			//alert(1);
			//아이디 넘겨줄 필요 x
			//state와 po_num 넘겨주면 ok
			let state = $(this).data("state");
			let num ="${post.po_num}";
			
			//확인하려고
			let like = {				
				li_po_num : num,
				li_state : state
			}
			//console.log(like);	
			
			//ajax로 복붙
			$.ajax({
				async : true, //true(비동기)
				url : '<c:url value="/post/like"/>', 
				type : 'post', 						//json으로 보낼때는 무조건 post... 중괄호 들어가서 get방식은 처리 못함
				data : JSON.stringify(like),		//바로 위에서 생성한 객체	 
				contentType : "application/json; charset=utf-8",
				//dataType : "json", 									
				success : function (data){
					console.log(data);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			
		});
	
	</script>
	
	
	<!-- 댓글 목록 조회 -->
	<script type="text/javascript">
	/*겹치는 애들 접어놓기 위해 여기에 다 넣어놓으려고 따로 뺌*/
		
		var cri = {							//댓글 페이지네이션 위해 -> var로 변경
			page : 1,						//기본 1페이지
			search : ${post.po_num}		//search : 게시글번호
		};
		
	
		function getCommentList(cri){		//cri는 나중에 쓸거라 호출할때 지금은 일단 넣지는 않을 예정
			//ajax로 댓글 리스트를 가져와 화면에 출력
			$.ajax({
				async : true, //비동기 : true(비동기), false(동기)
				url : '<c:url value="/comment/list"/>', 
				type : 'post', 
				data : JSON.stringify(cri),			//여기에 객체 들어갈 거기 때문에일단 빈 객체로 
				contentType : "application/json; charset=utf-8",
				//dataType : "json", 									//->이걸 지워서 json으로 주고 json이 아니라 object로 받음
				success : function (data){
					//console.log(data);
					//let list = data.list;//리스트로 보임
					/*for(comment of list){
						console.log(comment);//댓글 하나하나 꺼내서 보여줌
					}*/
					//drawCommentList(list);
					$(".comment-container").html(data);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			
			
		}
/*		function drawCommentList(list){
			
			if(list.length == 0){
				$(".comment-list").html(`<div class="text-center mb-3" >등록된 댓글이 없습니다.</div>`);
				return;
			}
			
			let str = '';
			for(comment of list){
				let btns = '';
				let replyBtn = '';
				let padding = '';
				
				//  회원이 댓글or답글 작성자이면 수정&삭제버튼 추가
				if(comment.co_me_id == '${user.me_id}'){
					btns = `
						<button class="btn btn-outline-warning">수정</button>
						<button class="btn btn-outline-danger">삭제</button>
					`;
					
				}

				// 댓글이면 답글 버튼 추가
				if(comment.co_num == comment.co_ori_num){
					replyBtn = `<button class="btn btn-outline-success btn-reply" data-num="\${comment.co_num}">답글</button>`
					// 밑에 있던 답글 버튼 그대로 잘라옴
					
				}
				// 답글이면 왼쪽 패딩 추가
				else{
					padding = 'pl-5';	// 패딩 left 5
				}
				
				str += `
					<div class="\${padding}">	
						<div class="comment-item form-control mb-3" style="min-height: auto; height: auto;">
							<div class="comment-wrap">
								<div class="comment-writer">\${comment.co_me_id}</div>
								<div class="comment-content">\${comment.co_content}</div>
							</div>
							<div class="comment-func mt-2">
								\${replyBtn}
								\${btns}
							</div>
						</div>
					</div>
				`
			}
			$(".comment-list").html(str);
			
		}*/
	
	
		getCommentList(cri);
	
	</script>
	
	<!-- 댓글 등록 -->
	<!-- 
	<script type="text/javascript">
		//$(".insert-form").submit(function(e){
		$(document).on("submit", ".insert-form", function(e){
			e.preventDefault();		//서버로 전송하지 말라고 ->비동기통신할거기때문에
			
			if('${user.me_id}' == ''){		//로그인 안했으면(빈문자열)
				if(confirm("로그인이 필요한 서비스입니다. \n로그인 페이지로 이동하시겠습니까?")){
					location.href = "<c:url value="/login"/>";
				}
				return false;
			}
			//let content = $("[name=co_content]").val().trim();
			let $obj = $(this).find("[name=co_content]");		//	focus 하기위해 분리. 객체변수라 $obj로 표시($안붙여도 문제 없지만 알아보기 편하라고)
			let content = $obj.val().trim();		//
			
			if(content == ''){
				alert("댓글 내용을 입력해 주세요.");
				$obj.focus();				//이거 위해 분리
				return false;
			}
			/*
			let formData =$(this).serialize();		// serialize : form태그 안에 있는 input들을 직렬화
			console.log(formData);	//(안에 있는 내용들이 and연산자로 묶임)
			*/
			
			let co_ori_num = $(this).find("[name=co_ori_num]").val();
			let co_po_num = $(this).find("[name=co_po_num]").val();
			let co_content = $(this).find("[name=co_content]").val();
			/*
			let obj = {						//vo로 한꺼번에 못 받으니 묶어서 보내려고
					co_po_num : $("[name=co_po_num]").val(),
					co_content : $("[name=co_content]").val()
			}*/
			let obj = {
					co_po_num : co_po_num,
					co_content : co_content,
					co_ori_num : co_ori_num	== 'undefined' ? 0 : co_ori_num	//일반 댓글 때문에
			}
			//console.log(obj);
			let url = ($(this).attr("action"));
			$.ajax({
				async : false, //비동기 : true(비동기), false(동기)
				url : url, 
				type : 'post', 
				data : JSON.stringify(obj), 
				contentType : "application/json; charset=utf-8",
				//dataType : "json", 
				success : function (data){					//boolean으로 받으려고.. 대부분 여기까지오면 성공하지만 로그인 한지 오래돼서 세션 만료된 상태로 글 작성 하려 하면 실패하게
					//console.log(data);
					if(data){
						alert("댓글을 등록했습니다.");
						getCommentList(); //댓글등록 한 뒤 입력한 댓글 가져오려고
					}else{
						alert("댓글을 등록하지 못했습니다.");
					}
					$obj.val("");			//댓글 등록 후 기존 입력 내용 지우기
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
				
			
			console.log(obj);
			console.log(JSON.stringify(obj));
			return false;
		});
	
	</script>
	
-->

	
	
	<!-- 답글 등록 -->
	<!-- 
	<script type="text/javascript">
	/*
		$(".btn-reply").click(function(e){
			alert(1);//얘가 btn-reply 등록 이벤트보다 먼저 실행(비동기실행으로 등록되기때문에) -> 이벤트 등록 안됨
		});*/
		$(document).on("click", ".btn-reply", function(e){	//요소가 아니라 문서에 이벤트 등록
			//alert(1);
			let co_num = $(this).data("num");
			let str = `
				<form class="input-group mb-3 insert-form reply mt-2" action="<c:url value="/comment/insert"/>" method="post">
					<input type="hidden" name="co_ori_num" value="\${co_num}">
					<input type="hidden" name="co_po_num" value="${post.po_num}">
				    <textarea rows="" cols="" class="form-control" name="co_content"></textarea>
					<button class="btn btn-outline-primary">답글 등록</button>				    
				</form>
			`
			$(this).parent().after(str);
		});
		
	
	
	</script>
	-->
	
	
</body>
</html>
