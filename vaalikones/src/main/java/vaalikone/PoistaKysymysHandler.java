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
		Connection con = null;
		try {
			System.out.println("1");
			con = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");

			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("DELETE FROM kysymykset WHERE KYSYMYS_ID = " + kysymys);
			try {
				stmt.executeUpdate("ALTER TABLE kysymykset DROP COLUMN KYSYMYS_ID");
				stmt.executeUpdate("ALTER TABLE kysymykset AUTO_INCREMENT = 1");
				stmt.executeUpdate("ALTER TABLE kysymykset ADD KYSYMYS_ID int NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST");
			}catch(Exception e) {
				
			}
			

			//ALTER TABLE `users` ADD `id` int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;

			System.out.println("4");
			System.out.println("Kysymys poistettu");
			response.sendRedirect(request.getContextPath() + "/PoistaKysymys.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}

	}

}
