<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String user = request.getParameter("user");
%>

이름 : <%=user%>
<br>
	AB형
<br>