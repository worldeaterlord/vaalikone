package vaalikone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.sql.jdbc.PreparedStatement;

/**
 * Servlet implementation class PoistaHandler
 */
@WebServlet(name = "PoistaHandler", urlPatterns = {"/PoistaHandler"})

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.parseInt(request.getParameter("poista"));
		
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/vaalikone", "root", "");
			
			Statement st = con.createStatement();
			String query = "SELECT * FROM ehdokkaat";
			PrintWriter id = response.getWriter();
			//Koodi kesken terveisin Robot3000
			ResultSet rs = st.executeQuery(query);
			
			String Delete = "DELETE FROM 'ehdokkaat' WHERE EHDOKAS_ID LIKE " + a + ";";
			java.sql.PreparedStatement del = con.prepareStatement(Delete);
			del.setInt(2, a);
			System.out.println(Delete);
			ResultSet rs2 = st.executeQuery(Delete);
			rs2.next();
			st.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		doGet(request, response);
		
	}

}
