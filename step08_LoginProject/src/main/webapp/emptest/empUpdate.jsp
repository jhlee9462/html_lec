<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	
%>
<form action="../update" method="post">
	<table border="1" align="center" width="500px">
		<tr>
			<td>사원번호</td>
			<td><input type="text" name="eno" value="<%= request.getParameter("eno") %>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>사원이름</td>
			<td><input type="text" name="ename" value="<%= request.getParameter("ename") %>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value="<%= request.getParameter("phone") %>"></td>
		</tr>
		<tr>
			<td>부서</td>
			<td><input type="text" name="dept" value="<%= request.getParameter("dept") %>"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="확인">
				<input type="button" value="취소" onclick="history.back()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>