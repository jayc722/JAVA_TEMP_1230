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

		<div class="form-group mt-3">
			<label class="form-label">내용</label> 
			<div class="form-control" id="content" style="min-height: 400px;">${post.po_content}</div>
		</div>
		<c:if test="${list.size() ne 0}">
			<div class="form-group">
				<label>첨부파일</label>
				<c:forEach items="${list }" var="file">
					<a class="form-control" href="<c:url value="/download${file.fi_name}"/>" download="${file.fi_ori_name}">${file.fi_ori_name }</a>
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
		<div class="comment-list">
			<!-- <div class="comment-item form-control mb-3" style="min-height: auto; height: auto;">
				<div class="comment-wrap">
					<div class="comment-writer">ad</div>
					<div class="comment-content">댓글입니다.</div>
				</div>
				<div class="comment-func mt-2">
					<button class="btn btn-outline-success">대댓</button>
					<button class="btn btn-outline-warning">수정</button>
					<button class="btn btn-outline-danger">삭제</button>
				</div> 
			</div> -->
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
	
	<div class="d-flex justify-content-between">	<!-- display flex 이용해서 목록 수정 삭제 뒤쪽에 붙이려고 -->
		<a href="<c:url value="/post/list"/>" class="btn btn-outline-success">목록으로 돌아가기</a>
		<c:if test="${user.me_id eq post.po_me_id}">
			<div class="btns">
				<a href="<c:url value="/post/update/${post.po_num}"/>" class="btn btn-outline-info">수정</a>
				<a href="<c:url value="/post/delete/${post.po_num}"/>" class="btn btn-outline-danger">삭제</a>
			</div>
		</c:if>
	</div>
	
	<script type="text/javascript">
	/*겹치는 애들 접어놓기 위해 여기에 다 넣어놓으려고 따로 뺌*/
		function getCommentList(cri){		//cri는 나중에 쓸거라 호출할때 지금은 일단 넣지는 않을 예정
			//ajax로 댓글 리스트를 가져와 화면에 출력
			$.ajax({
				async : true, //비동기 : true(비동기), false(동기)
				url : '<c:url value="/comment/list"/>', 
				type : 'post', 
				data : JSON.stringify({
					search : '${post.po_num}'	//검색어로 대체
					
				}),			//여기에 객체 들어갈 거기 때문에일단 빈 객체로 
				contentType : "application/json; charset=utf-8",
				dataType : "json", 
				success : function (data){
					//console.log(data);
					let list = data.list;//리스트로 보임
					/*for(comment of list){
						console.log(comment);//댓글 하나하나 꺼내서 보여줌
					}*/
					drawCommentList(list);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
			
			
		}
		function drawCommentList(list){
			let str = '';
			for(comment of list){
				let btns = '';
				if(comment.co_me_id == '${user.me_id}'){
					btns = `
						<button class="btn btn-outline-warning">수정</button>
						<button class="btn btn-outline-danger">삭제</button>
					`;
					
				}
				
				str += `
					<div class="comment-item form-control mb-3" style="min-height: auto; height: auto;">
						<div class="comment-wrap">
							<div class="comment-writer">\${comment.co_me_id}</div>
							<div class="comment-content">\${comment.co_content}</div>
						</div>
						<div class="comment-func mt-2">
							<button class="btn btn-outline-success">답글</button>
							\${btns}
						</div>
					</div>
				`
			}
			$(".comment-list").html(str);
			
		}
	
	
		getCommentList();
	
	</script>

	<script type="text/javascript">
		$(".insert-form").submit(function(e){
			e.preventDefault();		//서버로 전송하지 말라고 ->비동기통신할거기때문에
			
			if('${user.me_id}' == ''){		//로그인 안했으면
				if(confirm("로그인이 피요한 서비스입니다. \n로그인 페이지로 이동하시겠습니까?")){
					location.href = "<c:url value="/login"/>";
				}
				return false;
			}
			//let content = $("[name=co_content]").val().trim();
			let $obj = $("[name=co_content]");		//	focus 하기위해 분리. 객체변수라 $obj로 표시($안붙여도 문제 없지만 알아보기 편하라고)
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
			let obj = {						//vo로 한꺼번에 못 받으니 묶어서 보내려고
					co_po_num : $("[name=co_po_num]").val(),
					co_content : $("[name=co_content]").val()
			}
			
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
	

</body>
</html>
