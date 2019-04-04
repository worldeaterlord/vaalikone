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

/**
 * Servlet implementation class PoistaEhdokas
 */
@WebServlet(name = "PoistaEhdokas", urlPatterns = { "/PoistaEhdokas" })
public class PoistaEhdokas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PoistaEhdokas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");

			Statement st = con.createStatement();
			String query = "SELECT * FROM ehdokkaat";
			PrintWriter id = response.getWriter();

			ResultSet rs = st.executeQuery(query);
//			//Tässä on takaisin nappulan tietoja jotka rikkoo ton deleten...
//			id.println("<form action='AdminPage'method='POST'/>");
//			id.println("<input type = 'submit' value = 'takaisin'</input> ");
//			id.println(" <BR>");

			while (rs.next()) {
				PrintWriter out = response.getWriter();
				out.println(rs.getString("EHDOKAS_ID"));
				out.print(rs.getString("ETUNIMI"));
				out.println(" ");
				out.print(rs.getString("SUKUNIMI"));
				out.println(" ");
				out.println("<BR>");
				out.println(" ");

			}
			id.println("<form action='PoistaHandler'method='POST'/>");
			id.println("<input type = 'text' name='poista' </input>");
			id.println("<input type = 'submit' value = 'delete'</input>");
			st.close();

		} catch (Exception e) {
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
