package br.com.fumec.resources;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fumec.dao.impl.PessoaDAO;
import br.com.fumec.models.Pessoa;

@Path("pessoa")
public class PessoaResource {
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	
	@GET
	@Path("findall")
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

	

}
