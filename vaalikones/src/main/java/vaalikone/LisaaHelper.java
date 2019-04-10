package vaalikone;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LisaaHelper
 */
@WebServlet(name = "/LisaaHelper",  urlPatterns = { "/LisaaHelper" })
public class LisaaHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LisaaHelper() {
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

		Connection conn;
		Statement stm;
		
		String lisaa = request.getParameter("lisaa");
		
		String id = request.getParameter("id");
		String sukunimi = request.getParameter("Sukunimi");
		String etunimi = request.getParameter("Etunimi");
		String puolue = request.getParameter("Puolue");
		String paikkakunta = request.getParameter("Kotipaikkakunta");
		String ika = request.getParameter("ik‰");
		String MiksiE = request.getParameter("MiksiEduskuntaan");
		String MitaA = request.getParameter("Mit‰AsioitaHauluatEdist‰‰");
		String Am = request.getParameter("Ammatti");

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");
			stm = conn.createStatement();
			System.out.println("success");
			String sql = "INSERT INTO ehdokkaat (EHDOKAS_ID, SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, IKA, MIKSI_EDUSKUNTAAN, MITA_ASIOITA_HALUAT_EDISTAA, AMMATTI) VALUES (?, ?, ?, ?, ?, ? ,? ,? ,?)";
			System.out.println("1");
			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println("2");
			statement.setString(1, id);
			statement.setString(2, sukunimi);
			statement.setString(3, etunimi);
			statement.setString(4, puolue);
			statement.setString(5, paikkakunta);
			statement.setString(6, ika);
			statement.setString(7, MiksiE);
			statement.setString(8, MitaA);
			statement.setString(9, Am);

			System.out.println("3");
			statement.executeUpdate();
			System.out.println("Ehdokkaan tiedot lis‰tty onnistuneesti");
			response.sendRedirect(request.getContextPath() + "/LisaaEhdokas.jsp");
			conn.close();

		} catch (Exception ex) {
			System.out.println("error");
			System.out.println(ex.getMessage());
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
