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
 * Servlet implementation class BasketServlet
 */
@WebServlet(name = "Basket", urlPatterns = { "/basket" })
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head></head><body>");
		out.print("Cart List..<br>");
		
		HttpSession session = request.getSession();
		if (session != null) {
			ArrayList<String> list = (ArrayList<String>) session.getAttribute("shop");
			
			out.print("Product : " + list + "<br>");
		}
		
		out.print("<a href='product/product.html'>상품 선택</a>");
		out.print("</body></html>");
		out.close();
	}

}
