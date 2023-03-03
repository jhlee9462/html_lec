<%@page import="com.exam.entity.LoginEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p {
	color: limegreen;
	font-weight: bold;
	font-size: 30px;
}
body {
	margin: 0;
	padding: 0;
}
#menu {
	height: 100px;
	background-color: #eee;
}
a {
	text-decoration: none;
	display: inline-block;
	margin-top: 40px;
	font-weight: bold;
	width: 100px;
	text-align: center;
}
</style>
</head>
<body>
	<div id="menu">
		<a href="/log/index.jsp">처음화면</a>
		<%
		LoginEntity entity = (LoginEntity) session.getAttribute("logOK");
		
		if (entity == null) {
		%>
			<a href="/log/logtest/login.jsp">로그인화면</a>
		<%
		} else {
		%>
			<a href="/log/list">사원전체보기</a>
			<a href="/log/emptest/empInsert.jsp">사원추가하기</a>
			<a href="/log/logout">로그아웃</a>
			<span><b><%= entity.getName() %></b>님이 로그인 하셨습니다&nbsp;&nbsp;&nbsp;현재 소유하신 포인트는 <b><%= entity.getPoint() %></b>점 입니다</span>
		<%
		}
		%>
		<!-- 테스트님이 로그인 하셨습니다 현재 소유하신 포인트는 65.78점 입니다-->
	</div>