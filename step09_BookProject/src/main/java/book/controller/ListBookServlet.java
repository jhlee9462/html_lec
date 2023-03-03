package book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.biz.BookBiz;
import book.dto.BookDTO;

/**
 * Servlet implementation class ListBookServlet
 */
@WebServlet(name = "LIST", urlPatterns = { "/list" })
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BookBiz biz = new BookBiz();
		ArrayList<BookDTO> list = biz.getBookList();
		
		RequestDispatcher rd = request.getRequestDispatcher("book/bookList.jsp");
		request.setAttribute("bookList", list);
		rd.forward(request, response);
	}

}
