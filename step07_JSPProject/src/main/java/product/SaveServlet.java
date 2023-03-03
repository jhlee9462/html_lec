package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet(name = "Save", urlPatterns = { "/save" })
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String p = request.getParameter("item");
		HttpSession session =  request.getSession(); // 세션 객체 획득
		
		ArrayList<String> list = (ArrayList<String>) session.getAttribute("shop");
		// shop 으로 지정된 객체가 있으면 반환 없으면 null 리턴
		if (list == null) {
			list = new ArrayList<String>();
			list.add(p);
			session.setAttribute("shop", list);
		} else {
			list.add(p);
		}
		// ----------------------------------------------------------------------------------------
		PrintWriter out = response.getWriter();
		out.print("<html><head></head><body>");
		out.print("Product Added..<br>");
		out.print("<a href='basket'>My Cart..</a>");
		out.print("</body></html>");
		out.close();
	}

}
