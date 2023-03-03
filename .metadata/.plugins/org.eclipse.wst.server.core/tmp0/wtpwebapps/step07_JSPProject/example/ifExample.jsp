<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String color = request.getParameter("color");

String colorName = null;

if (color.equals("skyblue"))
	colorName = "하늘색";
else if (color.equals("limegreen"))
	colorName = "초록색";
else if (color.equals("yellow"))
	colorName = "노란색";
else {
	colorName = "없음";
	color = "white";
}
%>
<body bgcolor="<%= color %>">
	<%= name %>님이 좋아하는 색상은 <%= colorName %>입니다
</body>
</html>