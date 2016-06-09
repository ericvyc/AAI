package br.com.fumec.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fumec.dao.impl.EnderecoDAO;
import br.com.fumec.models.Endereco;

@Path("endereco")
public class EnderecoResource {
	
	private EnderecoDAO enderecoDAO = new EnderecoDAO();

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getById/{idEndereco}")
	public Endereco getEnderecoById(@PathParam(value = "idEndereco") Integer idEndereco) {
		return enderecoDAO.getEnderecoById(idEndereco);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("new")
	public void createEndereco(Endereco endereco) {
		enderecoDAO.createEndereco(endereco);
	}
	
}
