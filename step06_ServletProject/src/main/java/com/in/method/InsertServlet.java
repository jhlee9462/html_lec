package com.in.method;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet(name = "Insert", urlPatterns = { "/insert.do" })
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");

		PrintWriter out = response.getWriter();
		out.append("<html><head><title>InsertServlet</title></head><body><br><br>" + "이름 : " + name + " " + "전화 : "
				+ phone + " " + "주소 : " + addr + "<br>");
		
		Connection conn = null;
		// db에 저장
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "edu", "1234");
			conn.setAutoCommit(false);

		} catch (ClassNotFoundException e) {} catch (SQLException e) {}
		PreparedStatement pstmt = null;
		int n = 0;

		try {
			String sql = "INSERT INTO USERS VALUES (SEQ_NO.NEXTVAL, '" + name + "', '" + phone + "', '" + addr + "')";

			pstmt = conn.prepareStatement(sql);
			n = pstmt.executeUpdate();
			if (n > 0) {
				conn.commit();
				out.append("<br>데이터가 저장되었습니다.");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				out.append("<br>데이터 저장에 실패했습니다.");
			} catch (SQLException e1) {}
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {}
		}
		
		out.append("<br><a href='test/dbtest.html'>처음화면</a></body></html>");
	}

}
