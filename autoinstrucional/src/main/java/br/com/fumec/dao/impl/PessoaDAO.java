package br.com.fumec.dao.impl;

import java.util.List;

import javax.persistence.Query;

import br.com.fumec.dao.IPessoaDAO;
import br.com.fumec.models.Pessoa;

public class PessoaDAO extends BaseDAO implements IPessoaDAO {

	private static final long serialVersionUID = 3459713197334261189L;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> findAll() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM dawfumec.tb_pessoa LIMIT 5");
		
		Query query = getEntityManager().createNativeQuery(sb.toString(), Pessoa.class);
		
		return query.getResultList();
	}

		
}
