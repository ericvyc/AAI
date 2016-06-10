package br.com.fumec.dao;

import java.io.Serializable;

public interface IBaseDAO extends Serializable {

	public void abreTransacao();
	
	public void commit();
	
}
