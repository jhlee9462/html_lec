package book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.biz.LoginBiz;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(name = "LOGIN", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBiz biz = new LoginBiz();
		HttpSession session = request.getSession();
		String userId = request.getParameter("userId");
		RequestDispatcher rd = null;
		
		if (biz.getLoginUser(userId, request.getParameter("userPw"))) {
			session.setAttribute("loginOk", userId);
			session.setMaxInactiveInterval(86400);
			rd = request.getRequestDispatcher("login/loginOk.jsp");
		} else {
			rd = request.getRequestDispatcher("login/fail.jsp");
		}
		
		rd.forward(request, response);
	}

}
