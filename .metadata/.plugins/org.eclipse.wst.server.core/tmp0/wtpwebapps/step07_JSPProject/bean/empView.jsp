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
	%>
	<jsp:useBean id="ob" class="bean.EmpVo" scope="page"/>
	<!-- 
	import bean.EmpVo;
	EmpVo ob = new EmpVo();
	 -->
	<jsp:setProperty property="*" name="ob"/>
	<!-- 
	ob.setName(request.getParameter("name"));
	ob.setPhone(request.getParameter("phone"));
	ob.setAddr(request.getParameter("addr"));
	 -->
	이름 : <jsp:getProperty property="name" name="ob"/><br>
	번호 : <jsp:getProperty property="phone" name="ob"/><br>
	주소 : <jsp:getProperty property="addr" name="ob"/><br>
	<!-- 
	PrintWriter out = response.getWriter();
	out.print("이름 : " + ob.getName());
	out.print(" 번호 : " + ob.getPhone());
	out.print(" 주소 : " + ob.getAddr());
	 -->
	<br>
	이름 : <%= ob.getName() %><br>
	번호 : <%= ob.getPhone() %><br>
	주소 : <%= ob.getAddr() %><br>
</body>
</html>