package com.in.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class exam01
 */
@WebServlet("/exam01")
public class exam01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String[] color = {"red", "green", "blue"};
		out.print("<table border='1' width='200px'>");
		
		for (int i = 0; i < color.length; i++) {
			out.print("<tr><td>" + i + "</td>");
			out.print("<td>" + color[i] + "</td></tr>");
		}
		
		out.print("</table>");
	}

}
