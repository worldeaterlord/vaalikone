package vaalikone;

import entity.*;
import javax.persistence.EntityManager;
import javax.persistence.*;

public class EmClass {

	public static EntityManager getEm() {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

//		try {
			emf = Persistence.createEntityManagerFactory("vaalikones");
			em = emf.createEntityManager();

//		} catch (Exception e) {
//			em.getTransaction().rollback();
//		} 
//		finally {
//			em.close();
//		}
		return em;
	}

}