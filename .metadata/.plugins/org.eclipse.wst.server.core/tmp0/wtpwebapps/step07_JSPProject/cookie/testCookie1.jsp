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
			if (cook[i].getName().equals("logId1")) {
				cook[i].setMaxAge(0); // 쿠키 제거, 쿠키 설정시간을 0으로 설정
				response.addCookie(cook[i]);
			}
		}
	}
	%>
	<a href="testCookie2.jsp">다음으로 이동</a>
</body>
</html>