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
	request.setCharacterEncoding("UTF-8");
	String btype = request.getParameter("btype");
	
	if (btype.equals("A")) {
%>
		<jsp:forward page="A.jsp"/>
<%
	} else if (btype.equals("B")) {
%>
		<jsp:forward page="B.jsp"/>
<%
	} else if (btype.equals("AB")) {
%>
		<jsp:forward page="AB.jsp"/>
<%
	} else if (btype.equals("O")) {
%>
		<jsp:forward page="O.jsp"/>
<%
	}
%>
</body>
</html>