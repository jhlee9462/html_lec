package com.exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.biz.EmpBiz;
import com.exam.entity.EmpEntity;

/**
 * Servlet implementation class EmpUpdateServlet
 */
@WebServlet(name = "Update", urlPatterns = { "/update" })
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		EmpEntity emp = new EmpEntity(Integer.parseInt(request.getParameter("eno")), request.getParameter("ename"), request.getParameter("phone"), request.getParameter("dept"));
		
		EmpBiz biz = new EmpBiz();
		int r = biz.updateEmp(emp);
		
		if (r > 0) {
			response.sendRedirect("list");
		} else {
			response.sendRedirect("emptest/empUpdate.jsp");
		}
		
	}

}
