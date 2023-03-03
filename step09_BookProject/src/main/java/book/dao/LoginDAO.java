package book.dao;

import static common.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	public boolean getLoginUser(String id, String pass) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM MEMBER WHERE USERID = '" + id + "' AND USERPWD = '" + pass + "'";

		boolean isLogined = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isLogined = true;
			}
		} catch (SQLException e) {
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return isLogined;
	}
}
