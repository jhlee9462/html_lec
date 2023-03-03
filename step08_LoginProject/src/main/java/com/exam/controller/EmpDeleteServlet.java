package com.exam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.biz.EmpBiz;
import com.exam.entity.EmpEntity;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet(name = "Delete", urlPatterns = { "/delete" })
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int eno = Integer.parseInt(request.getParameter("eno")); // 이렇게 하면 int 의 최대범위의 사원수 밖에 처리하지 못하지만 과연 그런 회사가 존재할까?
		EmpBiz biz = new EmpBiz();
		
		int r = biz.deleteEmp(eno);
		
		if (r > 0) {
			response.sendRedirect("list");
		} else {
			response.sendRedirect("list");
		}
	}

}
