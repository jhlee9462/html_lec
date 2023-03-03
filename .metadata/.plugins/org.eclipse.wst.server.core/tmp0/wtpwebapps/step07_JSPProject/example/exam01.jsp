<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<!-- 스크립트릿 -->
	<%
	String val = "hello jsp";
	%>
	JSP 명령어로 작성한
	<%=val%><br>
	<br>
	<!-- 표현식(expression) -->

	<!-- jsp선언문 : 변수, 함수의 선언(정의) -->
	<%!int a = 5;
	int b = 3;

	public int plusMethod() {
		return a + b;
	}%>

	a + b =
	<%=plusMethod()%>

	<%
	String[] color = { "red", "green", "blue" };
	%>
	<table border="1" width="200px">
		<%
		for (int i = 0; i < color.length; i++) {
		%>
		<tr>
			<td><%=i%></td>
			<td><%=color[i]%></td>
		</tr>
		<%
		}
		%>
	</table>

</body>

</html>