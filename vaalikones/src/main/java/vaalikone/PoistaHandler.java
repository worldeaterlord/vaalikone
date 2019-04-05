package vaalikone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.sql.jdbc.PreparedStatement;

/**
 * Servlet implementation class PoistaHandler
 */
@WebServlet(name = "PoistaHandler", urlPatterns = { "/PoistaHandler" })

public class PoistaHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PoistaHandler() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String poista = request.getParameter("poista");
		request.getRequestDispatcher("/AdminPage.jsp").forward(request, response);
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");
			Statement stmt = con.createStatement();
			String sql = "delete from ehdokkaat where EHDOKAS_ID='?'";
			stmt.executeUpdate(("DELETE FROM ehdokkaat WHERE EHDOKAS_ID = \"" + poista + "\""));
			response.sendRedirect(request.getContextPath() + "/PoistaEhdokas");
			System.out.println("Ehdokkaan tiedot poistettu onnistuneesti");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

		}
	}
}
