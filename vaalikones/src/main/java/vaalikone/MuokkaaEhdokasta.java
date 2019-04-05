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
 * Servlet implementation class MuokkaaEhdokasta
 */
@WebServlet("/MuokkaaEhdokasta")
public class MuokkaaEhdokasta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuokkaaEhdokasta() {
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
		MuokkaaHelper con = new MuokkaaHelper();

		try {

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");

			Statement st = conn.createStatement();
			String query = "SELECT * FROM ehdokkaat";
			PrintWriter id = response.getWriter();
			PrintWriter out = response.getWriter();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				PrintWriter dubbi = response.getWriter();
				dubbi.println(rs.getString("EHDOKAS_ID"));
				dubbi.print(rs.getString("ETUNIMI"));
				dubbi.println(" ");
				dubbi.print(rs.getString("SUKUNIMI"));
				dubbi.println(" ");
				dubbi.println("<BR>");
				dubbi.println(" ");
			}
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet logic</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Muokkaa ehdokasta " + request.getContextPath() + "</h1>");
			out.println("<form action='MuokkaaHelper'method='POST'/>");
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
