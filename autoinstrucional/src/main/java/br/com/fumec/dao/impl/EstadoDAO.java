package br.com.fumec.dao.impl;

import java.util.List;

import javax.persistence.Query;

import br.com.fumec.dao.IEstadoDAO;
import br.com.fumec.models.Estado;
import manager.Manager;

public class EstadoDAO extends BaseDAO implements IEstadoDAO {

	private static final long serialVersionUID = 3459713197334261189L;
	
	@Override
	public Estado createEstado(Estado estado) {
		abreTransacao();
		Estado novo = Manager.getEntityManager().merge(estado);
		commit();
		return novo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findAll() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT * FROM dawfumec.tb_estado");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Estado.class);
		
		return query.getResultList();
	}

	//Apagar este método e refatorar no angular para usar o save no update e delete.
	@Override
	public Estado update(Estado estado) {
		abreTransacao();
		Estado novo = Manager.getEntityManager().merge(estado);
		commit();
		return novo;
	}

	@Override
	public void delete(Integer id) {
		abreTransacao();
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM dawfumec.tb_estado WHERE id =:id");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Estado.class);
		query.setParameter("id", id);
		
		query.executeUpdate();
		commit();
	}

	@Override
	public void deletarTodos() {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM dawfumec.tb_estado WHERE 1=1");
		
		Query query = Manager.getEntityManager().createNativeQuery(sb.toString(), Estado.class);
		
		query.executeUpdate();
	}
	
}
