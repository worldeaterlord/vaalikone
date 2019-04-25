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
	@Produces(MediaType.TEXT_HTML)
	public String a() {
		String b = "<html>"
				+ "<head>"
				+"</head>"
				+ "<body>"
				+ "<a href='http://localhost:8080/rest/ehd/kaikki'>"
				+ "<input type='button' value='Visit kaikki' />"
				+ "</a>"
				+ "<br>"
				+ "<br>"
				+ "Poista ehdokas"
				+ "<form action='http://localhost:8080/rest/ehd/poista' method='post'/>"
				+ "<input type='text' name='poista' />"
				+ "<input type='submit' value='delete'"
				+ "<br>"
				+ "<br>"
				+ "Uusi ehdokas"
				+ "<br>"
				+ "<form action='http://localhost:8080/rest/ehd/lisaaSivu' method='post'/>"
				+ "<input type='submit' value='add'"
				+ "<br>"
				+ "<br>"
				+ "Muokkaa ehdokasta"
				+ "<br>"
				+ "<form action='http://localhost:8080/rest/ehd/edit' method='post'/>"
				+ "<input type='text' name='muokkaa' />"
				+ "<input type='submit' value='edit'"
				+ "</body>"
				;
		return b;
	}
	
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
	@GET
	@Path("/lisaaSivu")
	@Produces(MediaType.TEXT_HTML)
	public String lisaaYksi() {

			
			String b = "<html>"
					+ "<head>"
					+"</head>"
					+ "Anna uuden ehdokkaan tiedot: "
					+ "<br>"
					+ "<form action='http://localhost:8080/rest/ehd/lisaa' method='post'/>"
					+ "<br>"
					+ "Ehdokas id"
					+ "<br>"
					+ "<input type='text' name='EhdokasId' />"
					+ "<br>"
					+ "Sukunimi"
					+ "<br>"
					+ "<input type='text' name='Sukunimi' />"
					+ "<br>"
					+ "Etunimi"
					+ "<br>"
					+ "<input type='text' name='Etunimi' />"
					+ "<br>"
					+ "Ikä"
					+ "<br>"
					+ "<input type='text' name='Ika' />"
					+ "<br>"
					+ "Puolue"
					+ "<br>"
					+ "<input type='text' name='Puolue' />"
					+ "<br>"
					+ "Kotipaikkakunta"
					+ "<br>"
					+ "<input type='text' name='Kotipaikkakunta' />"
					+ "<br>"
					+ "Miksi Eduskuntaan"
					+ "<br>"
					+ "<input type='text' name='MiksiEduskuntaan' />"
					+ "<br>"
					+ "Mitä asioita haluat edistää"
					+ "<br>"
					+ "<input type='text' name='MitaAsioitaHaluatEdistaa' />"
					+ "<br>"
					+ "Ammatti"
					+ "<br>"
					+ "<input type='text' name='Ammatti' />"
					+ "<br>"
					+ "<br>"
					+ "<input type='submit' value='add'"
					+ "<br>"
					+ "<br>"
					+ "</body>"
					;
			return b;
	}
	

	@GET
	@Path("/LisaaSivu/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public void LisaaEhdokas(@PathParam("param") Integer EhdokasId, String Sukunimi, String Etunimi, Integer Ika,String Puolue,String Kotipaikkakunta, String MiksiEduskuntaan, String MitaAsioitaHaluatEdistaa, String Ammatti ) {
			EntityManager em = EmClass.getEm();
			String kysely = "INSERT INTO ehdokkaat (EHDOKAS_ID, SUKUNIMI, ETUNIMI, IKA, PUOLUE, KOTIPAIKKAKUNTA, MIKSI_EDUSKUNTAAN, MITA_ASIOITA_HALUAT_EDISTAA, AMMATTI) VALUES (?, ?, ?, ?, ?, ? ,? ,? ,?)";
			Query query = em.createNamedQuery(kysely);
			query.setParameter(1, EhdokasId);
			query.setParameter(2, Sukunimi);
			query.setParameter(3, Etunimi);
			query.setParameter(4, Ika);
			query.setParameter(5, Puolue);
			query.setParameter(6, Kotipaikkakunta);
			query.setParameter(7, MiksiEduskuntaan);
			query.setParameter(8, MitaAsioitaHaluatEdistaa);
			query.setParameter(9, Ammatti);
			query.executeUpdate();
	}
}