package br.com.fumec.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fumec.dao.impl.EnderecoDAO;
import br.com.fumec.models.Endereco;

/* Recebe as requisições mapeadas para contexto/endereco/... */
@Path("endereco")
public class EnderecoResource {
	
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	

	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Endereco novoEndereco(Endereco endereco) throws Exception {
		try {
			return enderecoDAO.createEndereco(endereco);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Endereco atualizarEndereco(Endereco endereco) throws Exception {
		try {
			return enderecoDAO.update(endereco);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@GET
	@Path("findall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Endereco> findAll() throws Exception {
		try {
			return enderecoDAO.findAll();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@GET
	@Path("deleteall")
	public void deletarTodos() throws Exception {
		try {
			enderecoDAO.deletarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	@GET
	@Path("delete/{idEndereco}")
	public void deletarTodos(@PathParam(value="idEndereco") Integer idEndereco) throws Exception {
		try {
			enderecoDAO.delete(idEndereco);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}


}
