package vaalikone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginHandler
 */
@WebServlet(name = "Login", urlPatterns = { "/LoginHandler" })

public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String n = request.getParameter("uname");
		String p = request.getParameter("password");

		if (LoginHandlerHelper.check(n, p)) {
			response.sendRedirect(request.getContextPath() + "/AdminPage.jsp");
			session.setAttribute("uname", n);
		} else {
			out.println("K�ytt�j� tai salasana v��rin!");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}

		out.close();
	}
}
