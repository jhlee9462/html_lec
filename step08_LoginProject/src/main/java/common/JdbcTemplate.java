package common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcTemplate {

	public static Connection getConnection() {
		Connection conn = null;
		DataSource ds = null;
		
		try {
			Context context = new InitialContext();
			Context env = (Context) context.lookup("java:comp/env");
			ds = (DataSource) env.lookup("jdbc/ora");
			
			conn = ds.getConnection();
			conn.setAutoCommit(false);
		} catch (NamingException e) {
		} catch (SQLException e) {
		}
		
		return conn;
	}
	
	/*
	 * public static Connection getConnection() { Connection conn = null;
	 * 
	 * try { Class.forName("oracle.jdbc.driver.OracleDriver");// 1.드라이버로드 conn =
	 * DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "edu",
	 * "1234");
	 * 
	 * conn.setAutoCommit(false); } catch (ClassNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * // if(conn!=null) // System.out.println("연결 성공~");
	 * 
	 * return conn; }
	 */

	public static void close(ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void close(Statement stmt) {

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	---------------------------------------------------
	public static boolean isConnection(Connection conn) {
		boolean valid = true;

		try {
			if (conn == null || conn.isClosed())
				valid = false;
		} catch (SQLException e) {
			valid = false;
		}
		return valid;
	}

	public static void close(Connection conn) {

		if (isConnection(conn))
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public static void commit(Connection conn) {
		if (isConnection(conn))
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void rollback(Connection conn) {
		if (isConnection(conn))
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
