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
import java.util.List;
import com.google.appengine.repackaged.com.google.gson.Gson;

import persist.Ehdokkaat;

@Path("/ehdokkaatResti")
public class EhdokkaatResti {

	@GET
	@Path("/courses1")
	@Produces("application/json")
	public List<Object> courses1() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("vaalikones");
		EntityManager entitymanager = emfactory.createEntityManager();

		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		Root<Ehdokkaat> from = criteriaQuery.from(Ehdokkaat.class);

		CriteriaQuery<Object> select = criteriaQuery.select(from);
		TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
		List<Object> resultlist = typedQuery.getResultList();
		return resultlist;

	}

}