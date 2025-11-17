package wk1;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/meteo")
public class metoRessource {
	private static ArrayList<meteo> liste = new ArrayList<>();

    public metoRessource() {
    	if (liste.isEmpty()) { 
            liste.add(new meteo("tunis", LocalDate.of(2024, 4, 12), 35.2));
            liste.add(new meteo("sfax", LocalDate.of(2023, 10, 24), 37.4));
            liste.add(new meteo("sousse", LocalDate.of(2022, 2, 18), 25.1));
        }
	}	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response  getAll() {
		if(liste.size()==0) {
			return Response.status(Status.NO_CONTENT).entity(liste).build();
		}
		else
			return Response.ok().entity(liste).build();
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addmeteo(meteo m) {
		for(meteo i:liste) {
			if(i.getVille().equals(m.getVille()) && i.getDate().equals(m.getDate()) && i.getMesure()==m.getMesure()) {
				return Response.status(220).entity("meteo existe deja avec le meme donnees").build();
				
			}
		}
		liste.add(m);
		return Response.ok().entity(liste).build();
	}
	
	@GET
	@Path("/{ville}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getmeteo(@PathParam("ville") String ville) {
	    for (meteo m : liste) {
	        if (m.getVille().equals(ville)) {
	            return Response.ok().entity(m).build();
	        }
	    }
	    return Response.status(225).entity("ville inexistante").build();
	}


}
