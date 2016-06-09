package br.com.fumec.resources;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fumec.models.Estado;


@Path("rest")
public class TesteResource {

	@GET
	@Produces("text/html")
	public Response getStartingPage() {
		String output = "<h1>Hello World!<h1>" +
				"<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>";
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("json")
	public Estado testeJson() {
		return new Estado(1,"Minas Gerais", "MG", null, null);
	}
	
}
