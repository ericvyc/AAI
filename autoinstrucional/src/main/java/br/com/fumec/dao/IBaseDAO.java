package br.com.fumec.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

public interface IBaseDAO extends Serializable {

	public EntityManager getEntityManager();
	
}
