<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Cookie[] cook = request.getCookies();
	if (cook != null) {
		for (int i = 0; i < cook.length; i++) {
	%>
			Cookie name : <%= cook[i].getName() %> + <%= i %><br>
			Cookie value : <%= cook[i].getValue() %> + <%= i %><br><br>
	<%
		}
	}
	%>
</body>
</html>