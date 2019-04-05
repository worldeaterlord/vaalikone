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

import org.eclipse.persistence.internal.libraries.asm.tree.TryCatchBlockNode;

/**
 * Servlet implementation class MuokkaaKysymys
 */
@WebServlet(name = "MuokkaaKysymys", urlPatterns = { "/Muokkaakysymys" })
public class MuokkaaKysymys extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuokkaaKysymys() {
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

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");

			Statement st = con.createStatement();
			String query = "SELECT * FROM kysymykset";
			PrintWriter prw = response.getWriter();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				PrintWriter out = response.getWriter();
				out.println(rs.getString("KYSYMYS_ID"));
				out.println(" ");
				out.println(rs.getString("KYSYMYS"));
				out.println("<BR>");
			}
			
			prw.println("<form action='MuokkaaKysymysHandler'method='POST'/>");
			prw.println("<input type = 'text' name='poista' </input>");
			prw.println("<input type = 'submit' value = 'delete'</input>");

			

		} catch (Exception e) {
			System.out.println("Jotain meni vikaan");
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
