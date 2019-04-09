package vaalikone;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.io.Resources;

/**
 * Servlet implementation class KorjaaTietokanta
 */
@WebServlet(name = "KorjaaTietokanta", urlPatterns = {"/KorjaaTietokanta"})
public class KorjaaTietokanta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KorjaaTietokanta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("").append(request.getContextPath());
		Process process;
		try {
			//Runtime rt = Runtime.getRuntime();

			String url = Resources.getResource("vaalikone").getPath();
			process = Runtime.getRuntime().exec("mysql -u root"+url+".txt");
			response.getWriter().append(url + ".txt");
			String executeCommand = "";
		} catch (Exception e) {
			// TODO: handle exception
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
