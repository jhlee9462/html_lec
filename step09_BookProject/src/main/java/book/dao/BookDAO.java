package book.dao;

import static common.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.dto.BookDTO;

public class BookDAO {

	public ArrayList<BookDTO> getBookList() {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		Connection conn = getConnection();
		String sql = "SELECT * FROM BOOKSHOP";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BookDTO dto = new BookDTO(rs.getString("ISBN"), rs.getString("TITLE"), rs.getString("AUTHOR"), rs.getString("COMPANY"), rs.getInt("PRICE"));
				list.add(dto);
			}
		} catch (SQLException e) {
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return list;
	}

	public boolean bookInsert(BookDTO dto) {
		Connection conn = getConnection();
		String sql = "INSERT INTO BOOKSHOP VALUES ('" + dto.getIsbn() + "', '" + dto.getTitle() + "', '" + dto.getAuthor() + "', '" + dto.getCompany() + "', " + dto.getPrice() + ")";
		
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			n = pstmt.executeUpdate();
			
			if (n > 0) {
				commit(conn);
			}
		} catch (SQLException e) {
			rollback(conn);
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return n > 0;
	}
}
