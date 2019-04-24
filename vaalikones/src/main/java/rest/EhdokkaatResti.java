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
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.google.api.services.discovery.Discovery.Apis.List;
import persist.Ehdokkaat;
import vaalikone.EmClass;

@Path("/riistaservice")
public class EhdokkaatResti {

	@GET
	@Path("/riista")
	@Produces(MediaType.APPLICATION_JSON)
	public Ehdokkaat getEhdokasId() {
		System.out.println("Hei vain");
		Ehdokkaat r = new Ehdokkaat();
		return r;
	}

	@GET
	@Path("/kaikki")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Ehdokkaat> findAll() {
		EntityManager em = EmClass.getEm();
		Query query = em.createNamedQuery("Ehdokkaat.findAll",Ehdokkaat.class);
		ArrayList<Ehdokkaat> results = (ArrayList<Ehdokkaat>) query.getResultList();
		return results;
		
		
//		ArrayList<Ehdokkaat> lista = new ArrayList<>();
//		for (int i = 0; i < 5; i++) {
//			Ehdokkaat r = new Ehdokkaat();
//			lista.add(r);
//		}
//		return lista;
	}

}