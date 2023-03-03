package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.exam.entity.EmpEntity;
import static common.JdbcTemplate.*;

public class EmpDao {

	public int insertEmp(EmpEntity emp) {
		Connection conn = getConnection();
		String sql = "INSERT INTO EMP VALUES (SEQ_ENO.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		int r = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getPhone());
			pstmt.setString(3, emp.getDept());
			
			r = pstmt.executeUpdate();
			
			if (r > 0) {
				commit(conn);
			}
		} catch (SQLException e) {
			rollback(conn);
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return r;
	}

	public ArrayList<EmpEntity> listEmp() {
		ArrayList<EmpEntity> list = new ArrayList<>();
		
		Connection conn = getConnection();
		String sql = "SELECT * FROM EMP";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				EmpEntity emp = new EmpEntity(rs.getInt("eno") ,rs.getString("ename"), rs.getString("phone"), rs.getString("dept"));
				list.add(emp);
			}
		} catch (SQLException e) {
		}
		return list;
	}
	
	public int updateEmp(EmpEntity emp) {
		int r = 0;
		
		Connection conn = getConnection();
		String sql = "UPDATE EMP SET phone = ?, dept = ? WHERE eno = ? AND ename = ?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getPhone());
			pstmt.setString(2, emp.getDept());
			pstmt.setInt(3, emp.getEno());
			pstmt.setString(4, emp.getName());
			
			r = pstmt.executeUpdate();
			if (r > 0) {
				commit(conn);
			}
		} catch (SQLException e) {
			rollback(conn);
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return r;
	}

	public int deleteEmp(int eno) {
		
		Connection conn = getConnection();
		String sql = "DELETE FROM EMP WHERE ENO = ?";
		
		int r = 0;
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eno);
			
			r = pstmt.executeUpdate();
			if (r > 0) {
				commit(conn);
			}
		} catch (SQLException e) {
			rollback(conn);
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return r;
	}
}
