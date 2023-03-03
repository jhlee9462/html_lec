<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp"%>
<form action="../insert" method="post">
	<table border="0" align="center" width="350px">
		<tr>
			<td>이름</td>
			<td><input type="text" name="ename"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>부서명</td>
			<td><input type="text" name="dept"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="추가">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>