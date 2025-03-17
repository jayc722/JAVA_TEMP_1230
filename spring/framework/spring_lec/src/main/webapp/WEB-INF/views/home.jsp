<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- 
	서버에서 보낸 데이터를 처리할 때는 $`{화면에서사용할이름}`(인식돼버려서 역따옴표 넣어둠...)을 이용하여 활용	-> 중괄호 안 띄어쓰기로 여러 변수 구분. 중괄호 안에는 띄어쓰기 없앨것..
		단, 주의사항으로 `$`{}는 주석에서도 인식됨... 주석에서 사용시 조심...
		

 -->


<P>  서버에서 보낸 제 이름은 ${name}. </P>
</body>
</html>
