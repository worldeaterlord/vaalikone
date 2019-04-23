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
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.appengine.repackaged.com.google.gson.Gson;

import persist.Ehdokkaat;

import model.AccessManager;

@Path("/ehdokkaatResti")
public class EhdokkaatResti {
	
	@GET
	@Path("/courses")
	@Produces("application/json")
	public String courses()
	{
	String courses = null;
	ArrayList<Ehdokkaat> courseList = new ArrayList<Ehdokkaat>();
	try
	{
	courseList = new AccessManager().getCourses();
	Gson gson = new Gson();
	courses = gson.toJson(courseList);
	} catch (Exception e)
	{
	e.printStackTrace();
	}
	return courses;
	}
	}