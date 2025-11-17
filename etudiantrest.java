package com.istic.rest;

import java.util.ArrayList;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/etudiant")
public class etudiantrest {
	private static ArrayList<etudiant>liste;
	public etudiantrest(){
		liste=new ArrayList<etudiant>();
		liste.add(new etudiant(1,"ahmed",12.5));
		liste.add(new etudiant(2,"riheb",14));
		liste.add(new etudiant(3,"omar",15));
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		if(liste.size()==0)
			return Response.status(Status.NO_CONTENT).entity(liste).build();
		else
			return Response.ok().entity(liste).build();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEtudiant(@PathParam("id") int id) {
	    for (etudiant e : liste) {
	        if (e.getEtudiantId() == id) {
	            return Response.ok(e).build();
	        }
	    }
	    return Response.status(225).entity("Étudiant non trouvé").build();
	}
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response deleteEtudiant(@PathParam("id") int id) {
		boolean removed = liste.removeIf(e -> e.getEtudiantId() == id);
		if (removed) {
                return Response.ok("etudiant supprimé").build();
        }else {
                return Response.status(Status.NOT_FOUND).entity("Étudiant non trouvéb").build();
        }
    }
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateEtudiant(etudiant e1) {
		for (etudiant i : liste) {
            if (e1.getEtudiantId() ==i.getEtudiantId()) {
	            i.setEtudiantNom(e1.getEtudiantNom());
	            i.setEtudiantMoyenne(e1.getEtudiantMoyenne());
	            return Response.ok(liste).build();
	        }
	    }
        return Response.status(Status.NOT_FOUND).entity("Étudiant non trouvé").build();
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response ajouterEtudiant(etudiant e) {
		for (etudiant i : liste) {
			 if (i.getEtudiantId() == e.getEtudiantId())  {
		        return Response.status(Status.NO_CONTENT).entity("Étudiant existe deja").build();
			}}
			liste.add(e);
            return Response.ok(liste).build();
					
		
	}
	
	
	

}
