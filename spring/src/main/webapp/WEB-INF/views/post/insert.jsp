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

			<form action="">
				<div class="form-group mt-3">
					<label class="form-label">게시판</label> 
					<select class="form-control col-3 sel-type">
						<c:forEach items="${boardList}" var="board">
							<option value="${board.bo_name}">${board.bo_name}</option>
						</c:forEach>
					</select>		
				</div>
		
				<div class="form-group mt-3">
					<label class="form-label">제목</label> 
					<input type="text" class="form-control" value="${post.po_title}">	
				</div>
		
				<div class="form-group mt-3">
					<label class="form-label">내용</label> 
					<textarea class="border rounded p-3" id="content" style="min-height: 400px; white-space: pre-wrap;">${post.po_content}</textarea>
				</div>
		
				<div>
				
				</div>
		
			</form>

</body>
</html>