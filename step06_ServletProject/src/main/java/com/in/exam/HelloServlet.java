package com.in.exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(name = "hello.do", urlPatterns = { "/hello.do" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().print("<html><head><title>처음으로 만들어보는 서블릿</title></head>");
		response.getWriter().print("<body>");
		response.getWriter().print("넥스트서블릿<br>");
		response.getWriter().print("<a href='next.do'>다음으로</a>");
		response.getWriter().print("</body></html>");
	}

}
