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
		<a href="<c:url value="/post/list"/>" class="btn btn-outline-success">목록</a>
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
		<ul class="comment-list"></ul>
		<div class="comment-insert-box">
			<form class="input-group mb-3 insert-form" action="<c:url value="/comment/insert"/>" method="post">
			    <textarea rows="" cols="" class="form-control" name="co_content"></textarea>
				<button class="btn btn-outline-success">댓글 등록</button>				    
			</form>
		</div>
		
	</div>

	<script type="text/javascript">
		$(".insert-form").submit(function(){
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
				$obj.focus;				//이거 위해 분리
				return false;
			}
		});
	
	</script>
	

</body>
</html>
