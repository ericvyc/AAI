package br.com.fumec.resources;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fumec.dao.impl.EstadoDAO;
import br.com.fumec.models.Estado;

@Path("estado")
public class EstadoResource {
	
	private EstadoDAO estadoDAO = new EstadoDAO();
	
	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(value=TxType.REQUIRED)
	public Estado novoEstado(Estado estado) throws Exception {
		try {
			return estadoDAO.createEstado(estado);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(value=TxType.REQUIRED)
	public Estado atualizarEstado(Estado estado) throws Exception {
		try {
			return estadoDAO.update(estado);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@GET
	@Path("findall")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(value=TxType.REQUIRED)
	public List<Estado> findAll() throws Exception {
		try {
			return estadoDAO.findAll();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@GET
	@Path("deleteall")
	@Transactional(value=TxType.REQUIRED)
	public void deletarTodos() throws Exception {
		try {
			estadoDAO.deletarTodos();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	@GET
	@Path("delete/{idEstado}")
	@Transactional(value=TxType.REQUIRED)
	public void deletarTodos(@PathParam(value="idEstado") Integer idEstado) throws Exception {
		try {
			estadoDAO.delete(idEstado);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

}
