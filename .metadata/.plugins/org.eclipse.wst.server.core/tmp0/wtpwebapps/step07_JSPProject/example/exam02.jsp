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
	String str = "hello";
	%>
	<!-- 주석 처리 부분입니다. '소스 보기' 에 보임 -->
	
	<%-- 
		jsp 주석
		jsp 파일에서만 보이고 '소스 보기' 에서 나타나지 않음
		브라우저 쪽으로 내보내지 않는 문장
	 --%>
	 
	 <!-- <%= str %> 주석 안에서 보이는 변수 -->
	 <%= str %>
</body>
</html>