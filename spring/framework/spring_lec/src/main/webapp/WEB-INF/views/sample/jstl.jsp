<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL 예제</h1>
	<c:set var="name" value="홍길동" />
	<p>제 이름은 ${name} 입니다</p>
	${str}
	<!-- 얘는 태그가 그대로 적용돼버림 -->
	<c:out value="${str}" />
	<!-- 얘는 태그도 문자열로 인식됨 -->
	<br>
	<c:if test="${age >= 20 }">
		<h3>성인입니다.</h3>
	</c:if>
	<c:if test="${age < 20 }">
		<!-- 쌍따옴표와 달러 사이 공백 들어가거나 하면 출력 안됨. 중괄호 안은 상관없음. -->
		<h3>미성년입니다.</h3>
	</c:if>

	<c:choose>
		<c:when test="${age >= 20 }">
			<h3>성인입니다.</h3>
		</c:when>
		<c:otherwise>
			<h3>미성년입니다.</h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<h1>c:forEach 예제</h1>
	<!-- 1부터 5까지 출력 예제 -->
	<c:forEach begin="1" end="5" var="i" step="2">
		<b>${i}</b>
	</c:forEach>
	<hr>
	<ul>
		<c:forEach items="${list}" var="fruit" varStatus="vs">
			<li>
			${vs.count}.${fruit} 
			<c:if test="${vs.first}">New</c:if> 
			<c:if test="${vs.last}">Old</c:if>
			</li>
		</c:forEach>
	</ul>
	<hr>
	<h1>c:forTokens 예제</h1>
	<ul>
	<c:forTokens items="${'사과, 바나나, 포도, 오렌지'}" delims=", " var="token" varStatus="vs">
		<li>${vs.count}.${token}</li>
	</c:forTokens>
	</ul>	
	<h1>c:url 예제</h1>
	<c:url var="url" value ="/jstl" >
		<c:param name="name" value ="abc"/>
		<c:param name="age" value ="20"/>
	</c:url>
	<p>${url}</p>
	<hr>
	<h1>fmt:formatNumber</h1>
	10000 <br>
	<fmt:formatNumber value="10000" type="currency"/>
	
	<fmt:setLocale value="en_us"/><!-- 서버 로컬정보가 한국으로 지정돼있어서 setLocale이 반영되지는 않음. -->
	<fmt:formatNumber value="10000" type="currency"/>
	
	<fmt:setLocale value="ja_jp"/>
	
	<fmt:formatNumber value="10000" type="currency"/>
	<br>format하면 숫자 세자리마다 콤마, currency타입은 뒤에 달러표시
	
	<h1>fmt:formatDate</h1>
	${date} <br>
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/> <br>
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd EE요일"/>
	<br>
</body>
</html>