package br.com.fumec.dao.impl;

import br.com.fumec.dao.EnderecoDAO;
import br.com.fumec.models.Endereco;

public class EnderecoDAOImpl extends BaseDAOImpl implements EnderecoDAO {

	private static final long serialVersionUID = 1066361775521865671L;
	
	@Override
	public Endereco getEnderecoById(Integer idEndereco) {
		return getEntityManager().find(Endereco.class, idEndereco);
	}
	
	@Override
	public void createEndereco(Endereco endereco) {
		getEntityManager().persist(endereco);
	}

}
