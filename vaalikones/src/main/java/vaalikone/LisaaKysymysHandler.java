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
 * Servlet implementation class LisaaKysymysHandler
 */
@WebServlet("/LisaaKysymysHandler")
public class LisaaKysymysHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LisaaKysymysHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn;
		Statement stm;
		
		String kysymys_id = request.getParameter("kysymys_id");
		String Kysymys = request.getParameter("kysymys");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");
			stm = conn.createStatement();
			System.out.println("success");
			String sql = "INSERT INTO kysymykset (KYSYMYS_ID, KYSYMYS) VALUES (?, ?)";
			System.out.println("1");
			PreparedStatement statement = conn.prepareStatement(sql);
			System.out.println("2");
			statement.setString(1, kysymys_id);
			statement.setString(2, Kysymys);

			System.out.println("3");
			statement.executeUpdate();
			System.out.println("Uusi Kysymys lisätty onnistuneesti");
			response.sendRedirect(request.getContextPath() + "/LisaaKysymys.jsp");
			conn.close();

		} catch (Exception ex) {
			System.out.println("error");
			System.out.println(ex.getMessage());
		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
