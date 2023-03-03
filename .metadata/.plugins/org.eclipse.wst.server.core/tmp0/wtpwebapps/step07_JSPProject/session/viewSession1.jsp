<%@page import="java.util.Enumeration"%>
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
	Enumeration<String> ob = session.getAttributeNames();
	while (ob.hasMoreElements()) {
		String name = ob.nextElement(); // logId1, logId2
		String value = (String) session.getAttribute(name);
		out.print("session name : " + name + "<br>");
		out.print("session value : " + value + "<br>");
		out.print("session id : " + session.getId() + "<br><br>");
		
		if (name.equals("logId1")) {
			session.removeAttribute(name); // logId1 제거
		}
	}
	%>
	<a href="viewSession2.jsp">세션 정보 확인</a>
</body>
</html>