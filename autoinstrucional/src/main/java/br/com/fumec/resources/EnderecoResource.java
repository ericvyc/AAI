package br.com.fumec.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fumec.dao.impl.EnderecoDAOImpl;
import br.com.fumec.models.Endereco;
import br.com.fumec.service.EnderecoService;

@Path("endereco")
public class EnderecoResource {
	
	private EnderecoService enderecoService;

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getById/{idEndereco}")
	public Endereco getEnderecoById(@PathParam(value = "idEndereco") Integer idEndereco) {
		EnderecoDAOImpl dao = new EnderecoDAOImpl();
		return dao.getEnderecoById(idEndereco);
//		return enderecoService.getEnderecoById(idEndereco);

		
//		Cidade cidade = new Cidade();
//		cidade.setId(1);
//		cidade.setNome("Belo Horizonte");
//		cidade.setTbEnderecos(null);
//		
//		Estado estado = new Estado();
//		estado.setId(1);
//		estado.setNome("Minas Gerais");
//		estado.setSigla("MG");
//		estado.setTbEnderecos(null);
//		
//		Endereco endereco = new Endereco();
//		endereco.setId(1);
//		endereco.setLogradouro("Rua João Arantes");
//		endereco.setComplemento("Apto 201");
//		endereco.setTbCidade(cidade);
//		endereco.setTbEstado(estado);
//		
//		return endereco;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("new")
	public void createEndereco(Endereco endereco) {
		enderecoService.createEndereco(endereco);
	}
	
}
