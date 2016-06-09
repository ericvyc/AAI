package br.com.fumec.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fumec.dao.BaseDAO;

public class BaseDAOImpl implements BaseDAO {

	private static final long serialVersionUID = 3323964905894824336L;

	@Override
	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("autoinstrucional");
		return emf.createEntityManager();
	}

}
