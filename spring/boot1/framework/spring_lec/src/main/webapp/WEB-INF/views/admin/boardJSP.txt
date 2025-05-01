<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html>

<head>

</head>
<body>
	<h1>게시판 관리</h1>
	<!-- 게시판 목록 조회 -->
	<!-- ${list} -->
		<table class="table table-hover table-info">
		<thead>
			<tr>
				<th>게시판명</th>
				<th>기능</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>
						<input type = "text" value = "${board.bo_name}" class = "form-control">
					</td>
					<td class = "text-center">
						<button type = "button" class = "btn btn-outline-warning">수정</button>
						<button type = "button" class = "btn btn-outline-danger">삭제</button>
					</td>
				</tr>
			</c:forEach>
			<c:if test="${list.size() eq 0}">	<!-- ==0이나 eq0이나 아무쪽이나 사용해도 ㅇ -->
				<tr>
					<th colspan="2" class="text-center">등록된 게시판이 없습니다.</th>		<!-- td 개수 맞춰서 -->
				</tr>
			</c:if>
			
		</tbody>
	</table>


	<!-- 게시판 등록 -->
	<form action="<c:url value="/admin/board/insert"/>" method="post">
		<div class="input-group mb-10">
      		<input type="text" class="form-control" placeholder="게시판을 입력하세요." name="bo_name">
      		<button type="submit" class="btn btn-outline-sucess">등록</button><!-- 버튼 기본 타입 submit이라 생략해도 같음 -->
    	</div>
	</form>

	

</body>
</html>
