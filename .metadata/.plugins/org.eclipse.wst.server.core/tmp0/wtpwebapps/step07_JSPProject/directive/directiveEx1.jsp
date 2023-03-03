<%@page import="java.util.Random"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page info="jsp 프로그래밍을 공부하는 중"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp 지시어
	page 지시어 : 컨테이너에서 처리할 때 필요한 속성을 기술
	<%-- <%@ page 속성=값...%> --%>
	include 지시어 : 하나의 jsp 파일에 여러 개의 html, jsp 파일을 포함하는 형식, 데이터가 나갈때는 하나의 웹페이지로 나가게 됨
-->
	<%=getServletInfo()%><br>
	<%
	Calendar ca = Calendar.getInstance();
	int year = ca.get(Calendar.YEAR);
	int month = ca.get(Calendar.MONTH) + 1;
	int day = ca.get(Calendar.DAY_OF_MONTH);
	
	Random rd = new Random();
	int x = rd.nextInt();
	%>

	오늘 날짜 :
	<%=year%>년
	<%=month%>월
	<%=day%>일 입니다.<br><br>
	생성한 난수 : <%= x %>
</body>
</html>