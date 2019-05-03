package rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.google.api.services.discovery.Discovery.Apis.List;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.cloud.sql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import persist.Ehdokkaat;
import persist.Kysymykset;
import vaalikone.EmClass;

@Path("/kyss")
public class KysymyksetResti {

	// Kysymysten tulostaminen
	@GET
	@Path("/kys")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Kysymykset> getKys() {
		ArrayList<Kysymykset> kysLista = new ArrayList<>();
		EntityManager em = EmClass.getEm();
		Query query = em.createNamedQuery("Kysymykset.findAll");
		kysLista.addAll(query.getResultList());
		return kysLista;
	}
	// Kysymysten muokkaaminen
	@POST
	@Path("/muokKys")
	@Consumes(MediaType.APPLICATION_JSON)
	public void muokkaaKys(Kysymykset e) throws Exception {
		try {
			EntityManager em = EmClass.getEm();
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
		} catch (Exception t) {
			System.out.println(e.getKysymys());
		}
		System.out.println(e.getKysymys());
	}
	//Kysymysten Lisääminen
	@POST
	@Path("/lisKys")
	@Consumes(MediaType.APPLICATION_JSON)
	public void lisaaKys(Kysymykset e) throws Exception {
		try {
			EntityManager em = EmClass.getEm();
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} catch (Exception t) {
			System.out.println(e.getKysymys());
		}
		System.out.println(e.getKysymys());
	}
	// Kysymysten poistaminen
	@GET
	@Path("/poistaKys/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	public String poistaKysymys(@PathParam("param") int id) {

		String paluu = "Kysymys: " + id + " poistettu onnistuneesti";
		String error = "Error: ";
		try {
			EntityManager em = EmClass.getEm();
			em.getTransaction().begin();
			Kysymykset k = em.find(Kysymykset.class, id);
			em.remove(k);
			em.getTransaction().commit();
			return paluu;
		} catch (Exception e) {
			return error + e;
		}
	}

}
