<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<!-- 얘 추가 안해도 되긴함 -->
<html>
<head>
</head>

<body>
	<h1>게시글 리스트</h1>
	<!-- 서버에서 보내준 게시글 목록을 출력 -->
	<table class="table table-hover table-info">
		<thead>
			<tr>
				<th>번호</th>
				
				<th>게시판</th>
				
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="post">
				<tr>
					<td>${post.po_num}</td>
					<td>${post.po_bo_name}</td>
					<td><a href="<c:url value="/post/detail/${post.po_num}" />">${post.po_title}</a></td>
					<td>${post.po_me_id}</td>
					<td><fmt:formatDate value="${post.po_date}" pattern="yyyy-mm-dd HH:mm:ss"/> </td>
					<td>${post.po_view}</td>


				</tr>
			</c:forEach>
			<c:if test="${list.size() eq 0}">	<!-- ==0이나 eq0이나 아무쪽이나 사용해도 ㅇ -->
				<tr>
					<th colspan="6">등록된 게시글이 없습니다.</th> <!-- td 개수 맞춰서 -->
				</tr>
			</c:if>
			
		</tbody>
	</table>
	<a href="<c:url value="/post/insert"/>" class="btn btn-outline-success">게시글 등록</a>
	<!-- homecontroller에 /post/insert/가 없으니 getname/{name}/{age}가 얘를 잡아버림 - sample/{}/{}로 수정 -->
</body>
</html>
