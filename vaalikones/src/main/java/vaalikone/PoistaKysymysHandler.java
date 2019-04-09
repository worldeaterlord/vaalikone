package vaalikone;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PoistaKysymysHandler
 */
@WebServlet(name = "PoistaKysymysHandler", urlPatterns = { "/PoistaKysymysHandler" })

public class PoistaKysymysHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PoistaKysymysHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String kysymys = request.getParameter("poista");
		// request.getRequestDispatcher("/AdminPage.jsp").forward(request, response);
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM ehdokkaat WHERE KYSYMYS_ID = " + kysymys);
			response.sendRedirect(request.getContextPath() + "/PoistaKysymys.jsp");
			System.out.println("Kysymys poistettu");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}

	}

}
