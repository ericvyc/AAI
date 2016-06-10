package br.com.fumec.dao.impl;

import java.util.List;

import javax.persistence.Query;

import br.com.fumec.dao.IPessoaDAO;
import br.com.fumec.models.Pessoa;
import manager.Manager;

public class PessoaDAO extends BaseDAO implements IPessoaDAO {

	private static final long serialVersionUID = 3459713197334261189L;
	
	@Override
	public Pessoa create(Pessoa pessoa) {
		
		abreTransacao();
		Pessoa nova = Manager.getEntityManager().merge(pessoa);
		commit();
		return nova;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> findAll() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM dawfumec.tb_pessoa order by id desc limit 30");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Pessoa.class);
		
		return query.getResultList();
	}
	
	@Override
	public Pessoa findOne(Integer id) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM dawfumec.tb_pessoa WHERE id =:id ");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Pessoa.class);
		query.setParameter("id", id);
		
		return (Pessoa) query.getSingleResult();
	}
	
	//Apagar este método e refatorar no angular para usar o save no update e delete.
	@Override
	public Pessoa update(Pessoa pessoa) {
		
		abreTransacao();
		Pessoa nova = Manager.getEntityManager().merge(pessoa);
		commit();
		return nova;
	}

	@Override
	public void delete(Integer id) {
		abreTransacao();
		
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM dawfumec.tb_pessoa WHERE id =:id");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Pessoa.class);
		query.setParameter("id", id);
		
		query.executeUpdate();
		
		commit();
	}

	@Override
	public void deleteAll() {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM dawfumec.tb_pessoa WHERE 1=1");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Pessoa.class);		
		query.executeUpdate();
	}

		
}
