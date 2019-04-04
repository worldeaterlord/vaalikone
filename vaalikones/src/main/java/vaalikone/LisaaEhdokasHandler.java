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
 * Servlet implementation class LisaaEhdokasHandler
 */
@WebServlet(name = "LisaaEhdokasHandler", urlPatterns = { "/LisaaEhdokasHandler" })
public class LisaaEhdokasHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LisaaEhdokasHandler() {
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
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String Newuser = request.getParameter("LisaaSubmit");

			//TÄHÄN OON JÄÄNY, EI TOIMI :(
		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");
			Statement stmt = con.createStatement();
			
			String query = "insert into ehdokkaat (EHDOKAS_ID, SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, IKA, MIKSI_EDUSKUNTAAN, MITÄ_ASIOITA_HALUAT_EDISTAA, AMMATTI)" + " values ('?', '?', '?', '?', '?', '?', '?', '?', '?'))";
		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString (1, "EHDOKAS_ID");
		    preparedStmt.setString (2, "SUKUNIMI");
		    preparedStmt.setString (3, "ETUNIMI");
		    preparedStmt.setString (4, "PUOLUE");
		    preparedStmt.setString (5, "KOTIPAIKKAKUNTA");
		    preparedStmt.setString (6, "IKA");
		    preparedStmt.setString (7, "MIKSI_EDUSKUNTAAN");
		    preparedStmt.setString (8, "MITÄ_ASIOITA_HALUAT_EDISTAA");
		    preparedStmt.setString (9, "AMMATTI");

		    preparedStmt.execute();
			//PreparedStatement pst = con.prepareStatement("insert into ehdokkaat values(?,?,?,?,?,?,?,?,?)");
		      con.close();

			response.sendRedirect(request.getContextPath() + "/LisaaEhdokas");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
