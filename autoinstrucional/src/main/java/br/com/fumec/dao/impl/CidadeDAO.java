package br.com.fumec.dao.impl;

import java.util.List;

import javax.persistence.Query;

import br.com.fumec.dao.ICidadeDAO;
import br.com.fumec.models.Cidade;
import manager.Manager;

public class CidadeDAO extends BaseDAO implements ICidadeDAO {

	private static final long serialVersionUID = -5912032781118489648L;

	@Override
	public Cidade createCidade(Cidade cidade) {
		abreTransacao();
		Cidade novo = Manager.getEntityManager().merge(cidade);
		commit();
		return novo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> findAll() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM dawfumec.tb_cidade");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Cidade.class);
		
		return query.getResultList();
	}

	@Override
	public Cidade update(Cidade cidade) {
		abreTransacao();
		Cidade novo = Manager.getEntityManager().merge(cidade);
		commit();
		return novo;
	}

	@Override
	public void delete(Integer id) {
		abreTransacao();
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM dawfumec.tb_cidade WHERE id =:id");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Cidade.class);
		query.setParameter("id", id);
		
		query.executeUpdate();
		commit();
	}

	@Override
	public void deletarTodos() {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM dawfumec.tb_cidade WHERE 1=1");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Cidade.class);
		
		query.executeUpdate();
	}

}
