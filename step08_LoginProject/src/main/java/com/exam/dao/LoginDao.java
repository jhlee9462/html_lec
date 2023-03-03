package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.entity.LoginEntity;
import static common.JdbcTemplate.*;

public class LoginDao {
	
	public LoginDao() {
	}

	public LoginEntity getLoginUser(String id, String pwd) {
		
		Connection conn = getConnection();
		LoginEntity entity = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM USERS WHERE id = ? AND pwd = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				entity = new LoginEntity(rs.getString("id"), rs.getString("pwd"), rs.getString("name"), rs.getDouble("point"));
			}
			
		} catch (SQLException e) {
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return entity;
	}

}
