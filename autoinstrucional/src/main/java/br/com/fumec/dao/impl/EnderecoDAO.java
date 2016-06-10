package br.com.fumec.dao.impl;

import java.util.List;

import javax.persistence.Query;

import br.com.fumec.dao.IEnderecoDAO;
import br.com.fumec.models.Endereco;
import manager.Manager;

public class EnderecoDAO extends BaseDAO implements IEnderecoDAO {

	private static final long serialVersionUID = 7767775811795961460L;

	@Override
	public Endereco createEndereco(Endereco endereco) {
		abreTransacao();
		Endereco novo = Manager.getEntityManager().merge(endereco);
		commit();
		return novo;
	}

	@Override
	public List<Endereco> findAll() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM dawfumec.tb_endereco order by id desc limit 10");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Endereco.class);
		
		return query.getResultList();
	}

	@Override
	public Endereco update(Endereco endereco) {
		abreTransacao();
		Endereco novo = Manager.getEntityManager().merge(endereco);
		commit();
		return novo;
	}

	@Override
	public void delete(Integer id) {
		abreTransacao();
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM dawfumec.tb_endereco WHERE id =:id");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Endereco.class);
		query.setParameter("id", id);
		
		query.executeUpdate();
		commit();
	}

	@Override
	public void deletarTodos() {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM dawfumec.tb_endereco WHERE 1=1");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Endereco.class);
		
		query.executeUpdate();
	}

}
