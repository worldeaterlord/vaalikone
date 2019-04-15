package vaalikone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmLuokka
 */
@WebServlet("/EmLuokka")
public class EmLuokka extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmLuokka() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em = EmClass.getEm();
		EntityTransaction entitytransaction = em.getTransaction();
		entitytransaction.begin();
		Puheenjohtaja pj = new Puheenjohtaja();
		String e = request.getParameter("etunimi");
		String s = request.getParameter("sukunimi");
		int i = Integer.parseInt(request.getParameter("ika"));
		String pp = request.getParameter("pelipaikka");
		
		pj.setEtunimi(e);
		pj.setSukunimi(s);
		pj.setIka(i);
		pj.setPelipaikka(pp);
		em.persist(pj);
		em.getTransaction().commit();
		
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
