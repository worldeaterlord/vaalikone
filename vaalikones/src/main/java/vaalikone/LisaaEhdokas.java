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

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");

			Statement st = con.createStatement();
			String query = "SELECT * FROM ehdokkaat";
			PrintWriter id = response.getWriter();

			ResultSet rs = st.executeQuery(query);

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
			
			id.println("---------------------------------------");
			id.println("<BR>");

			id.println("<form action='./LisaaEhdokasHandler'method='POST'/>");
			id.println("Ehdokas id");
			id.println("<input type = 'text' name='EHDOKAS_ID' </input>");
			id.println("<BR>");
			id.println("Sukunimi");
			id.println("<input type = 'text' name='SUKUNIMI' </input>");
			id.println("<BR>");
			id.println("Etunimi");
			id.println("<input type = 'text' name='ETUNIMI' </input>");
			id.println("<BR>");
			id.println("Puolue");
			id.println("<input type = 'text' name='PUOLUE' </input>");
			id.println("<BR>");
			id.println("Kotipaikkakunta");
			id.println("<input type = 'text' name='KOTIPAIKKAKUNTA' </input>");
			id.println("<BR>");
			id.println("Ik‰");
			id.println("<input type = 'text' name='IKA' </input>");
			id.println("<BR>");
			id.println("Miksi eduskuntaan");
			id.println("<input type = 'text' name='MIKSI_EDUSKUNTAAN' </input>");
			id.println("<BR>");
			id.println("Mit‰ asioita haluat edist‰‰");
			id.println("<input type = 'text' name='MITƒ_ASIOITA_HALUAT_EDISTAA' </input>");
			id.println("<BR>");
			id.println("Ammatti");
			id.println("<input type = 'text' name='AMMATTI' </input>");
			id.println("<BR>");
			id.println("<input type = 'submit' value = 'LisaaSubmit'</input> ");

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
