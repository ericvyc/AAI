package br.com.fumec.dao;

import java.io.Serializable;

/* Interface de métodos de acesso a base de dados comum */
public interface IBaseDAO extends Serializable {

	public void abreTransacao();
	
	public void commit();
	
}
