package br.com.fumec.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fumec.dao.IBaseDAO;

public class BaseDAO implements IBaseDAO {

	private static final long serialVersionUID = -8903543658011390617L;
	
	private EntityManagerFactory emf;
	
	private EntityManager em;

	@Override
	public EntityManager getEntityManager(){
		
		if(emf == null){
			emf= Persistence.createEntityManagerFactory("autoinstrucional");
		}
		if(em == null) {
			em = emf.createEntityManager();
		}
		
		return em;
		
	}

}
