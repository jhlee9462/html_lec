package com.in.method;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTest
 */
@WebServlet(name = "get.do", urlPatterns = { "/get.do" })
public class GetTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 한글처리 (utf-8, euc-kr)
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();

		// 2. 데이터 가져오기
		String name = request.getParameter("irum");
		String pwd = request.getParameter("amho");
		
		// 3. 결과 출력
		out.print("<html><head><title>getTest</title></head>");
		out.print("<body>");
		out.print("<h3>Get Test</h3>");
		out.print("이름 : " + name + "<br>");
		out.print("암호 : " + pwd + "<br>"); 
		out.print("<a href='test/getTest.html'>처음화면</a>");
		out.print("</body></html>");
	}

}
