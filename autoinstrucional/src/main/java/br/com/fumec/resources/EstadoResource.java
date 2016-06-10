package br.com.fumec.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fumec.dao.impl.EstadoDAO;
import br.com.fumec.models.Estado;

@Path("estado")
public class EstadoResource {
	
	private EstadoDAO estadoDAO = new EstadoDAO();
	
	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response novoEstado(Estado estado) throws Exception {
		try {
			return estadoDAO.createEstado(estado);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@GET
	@Path("findall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estado> findAll() {
		return estadoDAO.findAll();
	}

}
