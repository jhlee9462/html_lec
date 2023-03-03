package com.in.method;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostTest1
 */
@WebServlet(name = "post1.do", urlPatterns = { "/post1.do" })
public class PostTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글처리 ( uft-8 ) : 클라이언트로부터 전송받은 데이터의 한글처리 ( post 에만 사용 )
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		// 2. 데이터 가져오기
		String name = request.getParameter("irum");
		String pwd = request.getParameter("amho");
		
		// 3. 출력
		out.print("<html><head><title>Post Test</title><style>a{text-decoration:none;}a:hover{text-decoration:underline;}</style></head><body>");
		out.print("<h3>Post Test1</h3>이름 : " + name + "<br>암호 : " + pwd + "<br><a href='test/postTest1.html'>처음 화면</a></body>");
	}

}
