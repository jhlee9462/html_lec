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
 * Servlet implementation class EmpInsertServlet
 */
@WebServlet(name = "Insert", urlPatterns = { "/insert" })
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
//		문제. empInsert.jsp 에서 넘어온 데이터를 EmpEntity 객체 emp 를 만들어서 저장하고 biz.insertEmp(emp)를 호출하세요
		EmpBiz biz = new EmpBiz();
		EmpEntity emp = new EmpEntity();
		emp.setName(request.getParameter("ename"));
		emp.setPhone(request.getParameter("phone"));
		emp.setDept(request.getParameter("dept"));
		int r = biz.insertEmp(emp);
		
		if (r > 0) {
			response.sendRedirect("list");
		} else {
			response.sendRedirect("emptest/empInsert.jsp");
		}
	}

}
