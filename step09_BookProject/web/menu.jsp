<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		margin: 0;
	}

	#menu {
		background-color: skyblue;
		padding: 0;
		margin: 0;
		width: 100%;
		height: 100px;
	}
	
	#menu a {
		text-decoration: none;
		margin: 40px;
		display: inline-block;
	}
	
	.login:focus {
		background-color: #F5F5DC;
	}
</style>
</head>
<body>
	<div id="menu">
		<%
		if (session.getAttribute("loginOk") != null) {
		%>
			<a href="/book/index.jsp">HOME</a>
			<a href="/book/book/bookInput.jsp">도서등록</a>
			<a href="/book/list">도서목록</a>
			<a href="/book/logout">로그아웃</a>
			<b><%= (String) session.getAttribute("loginOk") %></b>님이 로그인 하셨습니다
		<%
		} else {
		%>
			<a href="/book/index.jsp">처음화면</a>
			<a href="/book/login/login.jsp">로그인화면</a>
		<%
		}
		%>
	</div>