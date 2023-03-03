package com.in.method;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet(name = "List", urlPatterns = { "/list.do" })
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append("<html><head><title>InsertServlet</title></head><body>");
		
		Connection conn = null;
		// db에 저장
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "edu", "1234");
			conn.setAutoCommit(false);

		} catch (ClassNotFoundException e) {} catch (SQLException e) {}
		
		String sql = "SELECT * FROM USERS ORDER BY NUM DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			out.append("<table border='1' width='350px'>");
			
			while (rs.next()) {
				out.append("<tr><td>" + rs.getInt("num") + "</td><td>" + rs.getString("name") + "</td><td>" + 
						rs.getString("phone") + "</td><td>" + rs.getString("addr") + "</td></tr>");
			}
			
			out.append("</table>");
		} catch (SQLException e) {}
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {}
		}
		
		out.append("<a href='test/dbtest.html'>처음 화면</a></body></html>");
	}

}
