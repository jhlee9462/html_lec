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
	
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public static boolean isConnection(Connection conn) {
		boolean valid = true;
		
		try {
			if (conn == null || conn.isClosed()) {
				valid = false;
			}
		} catch (SQLException e) {
			valid = false;
		}
		
		return valid;
	}
	
	public static void close(Connection conn) {
		if (isConnection(conn)) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public static void commit(Connection conn) {
		if (isConnection(conn)) {
			try {
				conn.commit();
			} catch (SQLException e) {
			}
		}
	}
	
	public static void rollback(Connection conn) {
		if (isConnection(conn)) {
			try {
				conn.rollback();
			} catch (SQLException e) {
			}
		}
	}
}
