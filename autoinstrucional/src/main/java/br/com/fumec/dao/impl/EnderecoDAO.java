package br.com.fumec.dao.impl;

import java.util.List;

import javax.persistence.Query;

import br.com.fumec.dao.IEnderecoDAO;
import br.com.fumec.models.Endereco;
import manager.Manager;

public class EnderecoDAO extends BaseDAO implements IEnderecoDAO {

	private static final long serialVersionUID = 1066361775521865671L;
	
	@Override
	public Endereco getEnderecoById(Integer idEndereco) {
		return null;
	}
	
	@Override
	public void createEndereco(Endereco endereco) {
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> findAll() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM dawfumec.tb_endereco limit 5");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Endereco.class);
		
		return query.getResultList();
	}

}
