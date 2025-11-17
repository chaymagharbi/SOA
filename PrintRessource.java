package com.istic.rest;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/print")
public class PrintRessource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello Jax-rs" ;
	}
	
	@GET
	@Path("/helloYou")
	@Produces(MediaType.TEXT_PLAIN)
	public  String  sayHelloYou(@QueryParam(value="name") String name) {
		
		return "Hello "+name ;
		
	}
	
	@GET
	@Path("/helloYou2")
	@Produces(MediaType.TEXT_PLAIN)
	public  String  sayHelloYou2(@FormParam(value="name") String name) {
		
		return "Hello "+name ;
		
	}
	
	@GET
	@Path("/calcul")
	@Produces(MediaType.TEXT_PLAIN)
	public int calcul (@FormParam(value="a")int a, @FormParam(value="b")int b) {
		
		return a+b;
	}
	
	@GET 
	@Path("/getJson")
	@Produces(MediaType.APPLICATION_JSON)
    public  JsonObject getJson(@FormParam(value="name") String name)  {
		return Json.createObjectBuilder().add("nom",name ).build();
	}
	


}
