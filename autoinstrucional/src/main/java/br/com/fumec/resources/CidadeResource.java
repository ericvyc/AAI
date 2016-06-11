package br.com.fumec.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fumec.dao.impl.CidadeDAO;
import br.com.fumec.models.Cidade;

/* Recebe as requisições mapeadas para contexto/cidade/... */
@Path("cidade")
public class CidadeResource {
	
	private CidadeDAO cidadeDAO = new CidadeDAO();
	
	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cidade novoCidade(Cidade cidade) throws Exception {
		try {
			return cidadeDAO.createCidade(cidade);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cidade atualizarCidade(Cidade cidade) throws Exception {
		try {
			return cidadeDAO.update(cidade);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@GET
	@Path("findall")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cidade> findAll() throws Exception {
		try {
			return cidadeDAO.findAll();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@GET
	@Path("deleteall")
	public void deletarTodos() throws Exception {
		try {
			cidadeDAO.deletarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	@GET
	@Path("delete/{idCidade}")
	public void deletarTodos(@PathParam(value="idCidade") Integer idCidade) throws Exception {
		try {
			cidadeDAO.delete(idCidade);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
}
