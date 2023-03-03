<%@page import="com.exam.entity.EmpEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp"%>
<%
List<EmpEntity> list = (List<EmpEntity>) request.getAttribute("emp");
%>
<table border="1" align="center" width="500px">
	<tr>
		<td>사원번호</td>
		<td>사원이름</td>
		<td>전화번호</td>
		<td>부서</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<%
	for (EmpEntity emp : list) {
	%>
	<tr>
		<td><%= emp.getEno() %></td>
		<td><%= emp.getName() %></td>
		<td><%= emp.getPhone() %></td>
		<td><%= emp.getDept() %></td>
		<td>
			<form action="emptest/empUpdate.jsp" method="post">
				<input type="hidden" name="eno" value="<%= emp.getEno()%>">
				<input type="hidden" name="ename" value="<%= emp.getName()%>">
				<input type="hidden" name="phone" value="<%= emp.getPhone()%>">
				<input type="hidden" name="dept" value="<%= emp.getDept()%>">
				<input type="submit" value="수정">
			</form>
		</td>
		<td>
			<form action="/log/delete" method="post">
				<input type="hidden" name="eno" value="<%= emp.getEno()%>">
				<input type="submit" value="삭제" onclick="return confirm('삭제하시겠습니까?')">
			</form>
		</td>
	</tr>
	<%
	}
	%>
</table>
</body>
</html>