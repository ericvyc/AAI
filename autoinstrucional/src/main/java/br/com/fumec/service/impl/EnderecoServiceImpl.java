package br.com.fumec.service.impl;

import br.com.fumec.dao.EnderecoDAO;
import br.com.fumec.models.Endereco;
import br.com.fumec.service.EnderecoService;

public class EnderecoServiceImpl implements EnderecoService {

	private static final long serialVersionUID = 8844064283273426152L;
	
	private EnderecoDAO enderecoDAO;

	@Override
	public Endereco getEnderecoById(Integer idEndereco) {
		return enderecoDAO.getEnderecoById(idEndereco);
	}

	@Override
	public void createEndereco(Endereco endereco) {
		enderecoDAO.createEndereco(endereco);
	}

}
