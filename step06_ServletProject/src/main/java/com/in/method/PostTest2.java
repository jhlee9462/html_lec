package com.in.method;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostTest2
 */
@WebServlet(name = "post2.do", urlPatterns = { "/post2.do" })
public class PostTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("irum");
		int score = Integer.parseInt(request.getParameter("jumsoo"));
		
		String result = "";
		if (score >= 60) {
			result = "합격";
		} else {
			result = "불합격";
		}
		
		out.print("<html><head><title>postTest2</title></head><body><h3>Post Test2</h3>이름 : " + name + "<br>점수 : " 
				+ score + "<br>결과 : " + result + "<br><br><a href='test/postTest2.html'>처음화면</a></body>");
	}

}
