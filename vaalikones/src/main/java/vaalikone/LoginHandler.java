package vaalikone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginHandler
 */
@WebServlet(name = "Login", urlPatterns = {"/LoginHandler"})


public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Loginhandler").append(request.getContextPath());
//		String pw = null;
//		String un = null;
//	    PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    
	    String a = "dev";
	    String b = "qwerty";
	          
	    String n=request.getParameter("uname");  
	    String p=request.getParameter("password"); 
	    
	    if(!n.equals(a) && !p.equals(b)){  
	        out.println(n + p);  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
	    }  
	    else{  
	    	out.println("kukkuu");
	    	response.sendRedirect(request.getContextPath() + "/Adminpage");
	    }  
	          
	    out.close();  
	    }  

//		try {
//			pw = request.getParameter("password");
//			un = request.getParameter("uname");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		if(un=="dev") {
//			out.println("Käyttäjä oikein");
//			if(pw=="qwerty") {
//		        RequestDispatcher rd=request.getRequestDispatcher("AdminPage");  
//		        rd.forward(request, response);
//			}
//		}
		
	}
