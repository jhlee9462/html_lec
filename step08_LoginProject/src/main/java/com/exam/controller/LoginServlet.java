package com.exam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.biz.LoginBiz;
import com.exam.entity.LoginEntity;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
//		System.out.println(id + " " + pwd);
		
		LoginBiz biz = new LoginBiz();
		LoginEntity entity = biz.getLoginUser(id, pwd);
		// 세션 설정
		if (entity != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(86400);
			session.setAttribute("logOK", entity); // 세션이름 logOK
			
			// 현재 동작 파일 경로(파일명 포함), http://localhost:8080/log/login
//			System.out.println(request.getRequestURI());
			response.sendRedirect("logtest/loginOK.jsp");
		} else {
			response.sendRedirect("logtest/loginFail.jsp");
		}
	}

}
