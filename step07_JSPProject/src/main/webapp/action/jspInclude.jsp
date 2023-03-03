<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>***** 국가별 감사의 인사 *****</p>
	한국어 : 
	<jsp:include page="greeting.jsp">
		<jsp:param value="korea" name="country"/>
	</jsp:include>
	<br>
	일본어 : 
	<jsp:include page="greeting.jsp">
		<jsp:param value="japan" name="country"/>
	</jsp:include>
	<br>
	중국어 : 
	<jsp:include page="greeting.jsp">
		<jsp:param value="china" name="country"/>
	</jsp:include>
</body>
</html>