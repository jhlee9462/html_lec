package book.biz;

import java.util.ArrayList;

import book.dao.BookDAO;
import book.dto.BookDTO;

public class BookBiz {
	public ArrayList<BookDTO> getBookList() {
		BookDAO dao = new BookDAO();
		return dao.getBookList();
	}
	
	public boolean bookInsert(BookDTO dto) {
		BookDAO dao = new BookDAO();
		return dao.bookInsert(dto);
	}
}
