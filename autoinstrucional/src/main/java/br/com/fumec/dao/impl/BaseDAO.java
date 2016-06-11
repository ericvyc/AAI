package br.com.fumec.dao.impl;

import br.com.fumec.dao.IBaseDAO;
import manager.Manager;

/* Implementação de métodos de acesso a base de dados para comum */
public class BaseDAO implements IBaseDAO {

	private static final long serialVersionUID = -8903543658011390617L;
	
	@Override
	public void abreTransacao() {
		Manager.getEntityManager().getTransaction().begin();
	}

	@Override
	public void commit() {
		Manager.getEntityManager().getTransaction().commit();
	}

}
