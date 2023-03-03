<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String phone = request.getParameter("phone");
%>
나의 이름은 <%= name %> 이고 <%= age %> 세이며 연락처는 <%= phone %> 입니다