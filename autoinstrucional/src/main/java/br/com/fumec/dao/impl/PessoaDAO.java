package br.com.fumec.dao.impl;

import java.util.List;

import javax.persistence.Query;

import br.com.fumec.dao.IPessoaDAO;
import br.com.fumec.models.Pessoa;

public class PessoaDAO extends BaseDAO implements IPessoaDAO {

	private static final long serialVersionUID = 3459713197334261189L;
	
	@Override
	public Pessoa create(Pessoa pessoa) {
		return getEntityManager().merge(pessoa);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> findAll() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM dawfumec.tb_pessoa");
		
		Query query = getEntityManager().createNativeQuery(sb.toString(), Pessoa.class);
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Pessoa findOne(Integer id) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM dawfumec.tb_pessoa WHERE id =:id ");
		
		Query query = getEntityManager().createNativeQuery(sb.toString(), Pessoa.class);
		query.setParameter("id", id);
		
		return (Pessoa) query.getSingleResult();
	}
	
	//Apagar este método e refatorar no angular para usar o save no update e delete.
	@Override
	public Pessoa update(Pessoa pessoa) {
		return getEntityManager().merge(pessoa);
	}

	@Override
	public void delete(Integer id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM dawfumec.tb_pessoa WHERE id =:id");
		
		Query query = getEntityManager().createNativeQuery(sb.toString(), Pessoa.class);
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

	@Override
	public void deleteAll() {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM dawfumec.tb_pessoa WHERE 1=1");
		
		Query query = getEntityManager().createNativeQuery(sb.toString(), Pessoa.class);		
		query.executeUpdate();
	}

		
}
