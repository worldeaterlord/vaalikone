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
import vaalikone.EmClass;

@Path("/ehd")
public class EhdokkaatResti {
	// Näytetään kaikki
	@GET
	@Path("/kaikki")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Ehdokkaat> getKaikki() {
		ArrayList<Ehdokkaat> lista = new ArrayList<>();
		EntityManager em = EmClass.getEm();
		Query query = em.createNamedQuery("Ehdokkaat.findAll");

		lista.addAll(query.getResultList());
		return lista;
	}

	// Ehdokkaan poistaminen
	@GET
	@Path("/poista/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public void poistaYksi(@PathParam("param") String id) {
			EntityManager em = EmClass.getEm();
			String kysely = "delete from ehdokkaat where ehdokas_id="+id;
			Query query = em.createNativeQuery(kysely);
			query.executeUpdate();

	}

	// Ehdokkaan muokkaaminen
	@POST
	@Path("/a")
	@Consumes(MediaType.APPLICATION_JSON)
	public void muokkaa(Ehdokkaat e) throws Exception {
		try {
			EntityManager em = EmClass.getEm();
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
		} catch (Exception t) {
			System.out.println(e.getEtunimi());
		}
		System.out.println(e.getEtunimi());
	}

	// Ehdokkaan lisääminen
	@POST
	@Path("/b")
	@Consumes(MediaType.APPLICATION_JSON)
	public void lisaa(Ehdokkaat e) throws Exception {
		try {
			EntityManager em = EmClass.getEm();
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} catch (Exception t) {
			System.out.println(e.getEtunimi());
		}
		System.out.println(e.getEtunimi());
	}
}
