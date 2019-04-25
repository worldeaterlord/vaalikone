package rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.google.api.services.discovery.Discovery.Apis.List;
import com.google.appengine.repackaged.com.google.gson.Gson;

import persist.Ehdokkaat;
import vaalikone.EmClass;

@Path("/ehd")
public class EhdokkaatResti {

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

	@GET
	@Path("/poista/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public void poistaYksi(@PathParam("param") String id) {
			EntityManager em = EmClass.getEm();
			String kysely = "delete from ehdokkaat where ehdokas_id="+id;
			Query query = em.createNamedQuery(kysely);
			query.executeUpdate();

	}
	@POST
	@Path("/a")
	@Consumes(MediaType.APPLICATION_JSON)
	public void abc(Ehdokkaat e) throws Exception {
		try {
		EntityManager em = EmClass.getEm();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		}catch(Exception t){
			System.out.println(e.getEtunimi());
		}
		System.out.println(e.getEtunimi());
	}

}
