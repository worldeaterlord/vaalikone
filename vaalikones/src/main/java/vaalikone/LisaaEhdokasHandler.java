package vaalikone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");
			

			// Create a SQL query to insert data into demo table
			// demo table consists of two columns, so two '?' is used
			PreparedStatement st = con.prepareStatement("insert into ehdokas values(?, ?, ? ,? ,? ,? ,? ,? ,?)");

			// For the first parameter,
			// get the data using request object
			// sets the data to st pointer
			st.setInt(1, Integer.valueOf(request.getParameter("EHDOKAS_ID")));

			st.setString(2, request.getParameter("SUKUNIMI"));

			st.setString(3, request.getParameter("ETUNIMI"));

			st.setString(4, request.getParameter("PUOLUE"));

			st.setString(5, request.getParameter("KOTIPAIKKAKUNTA"));

			st.setInt(6, Integer.valueOf(request.getParameter("IKA")));

			st.setString(7, request.getParameter("MIKSI_EDUSKUNTAAN"));

			st.setString(8, request.getParameter("MITA_ASIOITA_HALUAT_EDISTAA"));

			st.setString(9, request.getParameter("AMMATTI"));

			// Execute the insert command using executeUpdate()
			// to make changes in database
			st.executeUpdate();

			// Close all the connections
			st.close();
			con.close();

			// Get a writer pointer
			// to display the succesful result
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>Successfully Inserted" + "</b></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
