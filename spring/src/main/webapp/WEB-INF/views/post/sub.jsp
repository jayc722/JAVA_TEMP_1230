<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<!-- 서버에서 보낸 게시글 목록을 이용하여 화면 구성. 이미지는 일단 이대로 고정 -->
			
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


		<div class="form-group">
			<c:forEach items="${postList}" var="post">
				<div class="form-control input-group" style="min-height : auto; height : auto">
					<img width="100" height="120" alt="" src="https://static.cdn.kmong.com/gigs/2syJC1722251676.jpg">
					<div class="ml-3">
						<div>${post.po_title }</div>
						<div>작성자 : ${post.po_me_id}</div>
						<div>작성일 : <fmt:formatDate pattern="yy.MM.dd" value="${post.po_date }"/> </div>
						<div>조회수 : ${post.po_view }</div>
						<div>추천수 : ${post.po_up }</div>
					</div>
				</div>
			</c:forEach>
			<c:if test="${postList.size() eq 0}">
				<div class="form-control text-center">등록된 게시글이 없습니다.</div>
			</c:if>
		
		</div>		
	

</body>
</html>