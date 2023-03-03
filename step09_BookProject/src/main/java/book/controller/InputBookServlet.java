package book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.biz.BookBiz;
import book.dto.BookDTO;

/**
 * Servlet implementation class InputBookServlet
 */
@WebServlet(name = "INPUT", urlPatterns = { "/input" })
public class InputBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BookDTO dto = new BookDTO(request.getParameter("isbn"), request.getParameter("title"), request.getParameter("author"), request.getParameter("company"), Integer.parseInt(request.getParameter("price")));
		BookBiz biz = new BookBiz();
		
		if (biz.bookInsert(dto)) {
			response.sendRedirect("list");
		} else {
			response.sendRedirect("book/bookInput.jsp");
		}
		
	}

}
