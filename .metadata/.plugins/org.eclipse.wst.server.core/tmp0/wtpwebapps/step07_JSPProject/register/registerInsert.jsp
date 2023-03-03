<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="ob" class="register.RegisterEntity" scope="session"></jsp:useBean>
<body>
	<!-- 커넥션 풀 사용방식 -->
	<%
	Connection conn = null;
	DataSource ds = null;

	try {
		Context context = new InitialContext();
		Context env = (Context) context.lookup("java:comp/env");
		ds = (DataSource) env.lookup("jdbc/OracleDB");

		// java:comp/env
		// 설정된  엔트리와 자원 (Resource) 은 JNDI namespace 의 java:comp/env 부분에 놓이게 되고
		// 자원에 대해 접근하려면 lookup ("java:comp/env") 을 통해 로컬리소스에 접근

		conn = ds.getConnection();
		conn.setAutoCommit(false);
	} catch (SQLException e) {
	} catch (NamingException e) {
	}
	%>

	<%-- <%
	Connection conn = null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "edu", "1234");
		conn.setAutoCommit(false);
	} catch (SQLException e) {
	%>
	<script>
			alert("conn 객체를 생성할 수 없습니다");
		</script>
	<%
	} catch (ClassNotFoundException e) {
	%>
	<script>
			alert("드라이버 로드에 실패했습니다");
	</script>
	<%
	} --%>
	<%
	String sql = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?, ?)";

	PreparedStatement pstmt = null;
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ob.getMem_id());
		pstmt.setString(2, ob.getMem_passwd());
		pstmt.setString(3, ob.getMem_name());
		pstmt.setString(4, ob.getMem_email());
		pstmt.setString(5, ob.getMem_phone());
		pstmt.setString(6, ob.getMem_zipcode());
		pstmt.setString(7, ob.getMem_addr());

		int n = pstmt.executeUpdate();

		if (n > 0) {
	%>
	<script>
				alert("<%=ob.getMem_name()%>님 회원가입 되셨습니다");
	</script>
	<%
	conn.commit();
	}
	} catch (SQLException e) {
	%>
	<script>
		alert("회원가입에 실패했습니다");
	</script>
	<%

	try {
		conn.rollback();
	} catch (SQLException e1) {
	}
	} finally {
	try {
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	} catch (SQLException e) {
	}
	}
	%>
</body>
</html>