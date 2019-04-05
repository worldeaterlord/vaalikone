package vaalikone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LisaaEhdokas", urlPatterns = { "/LisaaEhdokas" })

public class LisaaEhdokas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LisaaEhdokas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 response.setContentType("text/html;charset=UTF-8");
	        String name = request.getParameter("name");
	        LisaaHelper con = new LisaaHelper();
	        
	        
	        try (PrintWriter out = response.getWriter()) {
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet logic</title>");            
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Lis‰‰ ehdokas " + request.getContextPath() + "</h1>");
	            out.println("<form action='LisaaHelper'method='POST'/>");
	            out.println("Ehdokas ID");
	            out.println("<br>");
				out.println("<input type = 'text' name='id' </input><br>");
	            out.println("Sukunimi");
	            out.println("<br>");
				out.println("<input type = 'text' name='Sukunimi' </input><br>");
	            out.println("Etunimi");
	            out.println("<br>");
				out.println("<input type = 'text' name='Etunimi' </input><br>");
	            out.println("Puolue");
	            out.println("<br>");
				out.println("<input type = 'text' name='Puolue' </input><br>");
	            out.println("Kotipaikkakunta");
	            out.println("<br>");
				out.println("<input type = 'text' name='Kotipaikkakunta' </input><br>");
	            out.println("Ik‰");
	            out.println("<br>");
				out.println("<input type = 'text' name='ik‰' </input><br>");
	            out.println("Miksi Eduskuntaan");
	            out.println("<br>");
				out.println("<input type = 'text' name='MiksiEduskuntaan' </input><br>");
	            out.println("Mit‰ asioita haluat edist‰‰");
	            out.println("<br>");
				out.println("<input type = 'text' name='Mit‰AsioitaHauluatEdist‰‰' </input><br>");
	            out.println("Ammatti");
	            out.println("<br>");
				out.println("<input type = 'text' name='Ammatti' </input><br>");
				out.println("<input type = 'submit' value='lisaa' </input><br>");
	            out.println("</body>");
	            out.println("</html>");
	        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
