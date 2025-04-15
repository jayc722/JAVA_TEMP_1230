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

<body><!-- 기존거 가져와서 html만 남김 -->
	<c:choose>
		<c:when test="${post ne null}">
		<h1>게시글 상세</h1>
			<div>
			
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
				<div class="form-group mt-3 d-flex justify-content-center" id="btns">
					<button class="btn btn<c:if test="${like.li_state ne 1}">-outline</c:if>-success btn-up" data-state="1">추천(<span>${post.po_up}</span>)</button>
					<button class="btn btn<c:if test="${like.li_state ne -1}">-outline</c:if>-danger ml-3 btn-down" data-state="-1">비추천(<span>${post.po_down}</span>)</button>	<!-- 추천 비추천 한번에 처리하려고!! -->
				</div>
		
				<div class="form-group mt-3">
					<label class="form-label">내용</label> 
					<div class="border rounded p-3" id="content" style="min-height: 400px; white-space: pre-wrap;">${post.po_content}</div>
				</div>
				<!-- ${fileList}  -->
				<div class="mb-3">
					<c:forEach items = "${fileList}" var = "file">
						<img alt="첨부파일" width="100" height="120" src="<c:url value="/download${file.fi_name}"/>">
					
					</c:forEach>
				
				</div>

			</div>			
		</c:when>
		<c:otherwise>
			<h1>등록되지 않았거나 삭제된 게시글입니다.</h1>
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
	<div class="comment-container"></div>
	
	
	
	
	
	
	

	
	
</body>
</html>
