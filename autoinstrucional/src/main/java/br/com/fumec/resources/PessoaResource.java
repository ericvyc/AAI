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

import br.com.fumec.dao.impl.PessoaDAO;
import br.com.fumec.models.Pessoa;

@Path("pessoa")
public class PessoaResource {
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	@POST
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(value=TxType.REQUIRED)
	public Pessoa novaPessoa(Pessoa pessoa) throws Exception {
		try {
			return pessoaDAO.create(pessoa);
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
	public Pessoa atualizarPessoa(Pessoa pessoa) throws Exception {
		try {
			return pessoaDAO.update(pessoa);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@GET
	@Path("findAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(value=TxType.REQUIRED)
	public List<Pessoa> findAll() throws Exception {
		try {
			return pessoaDAO.findAll();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@GET
	@Path("findOne/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional(value=TxType.REQUIRED)
	public Pessoa findOne(@PathParam(value="id") Integer id) throws Exception {
		try {
			return pessoaDAO.findOne(id);
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	@GET
	@Path("deleteAll")
	@Transactional(value=TxType.REQUIRED)
	public void deletarTodos() throws Exception {
		try {
			pessoaDAO.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	@GET
	@Path("delete/{id}")
	@Transactional(value=TxType.REQUIRED)
	public void deletarTodos(@PathParam(value="id") Integer id) throws Exception {
		try {
			pessoaDAO.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

}
