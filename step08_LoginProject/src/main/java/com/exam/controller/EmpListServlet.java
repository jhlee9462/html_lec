package com.exam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.biz.EmpBiz;
import com.exam.entity.EmpEntity;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet(name = "List", urlPatterns = { "/list" })
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		EmpBiz biz = new EmpBiz();
		
		ArrayList<EmpEntity> list = biz.listEmp();
		
		if (list.size() == 0) {
			response.sendRedirect("/log/menu.jsp"); // list 가 없을 경우 메뉴를 표시
		} else {
//			System.out.println("ok list");
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("emptest/empList.jsp");
			request.setAttribute("emp", list);
			rd.forward(request, response);
		}
		
		
	}

}
