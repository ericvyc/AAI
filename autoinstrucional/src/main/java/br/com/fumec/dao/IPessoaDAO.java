package br.com.fumec.dao;

import java.io.Serializable;
import java.util.List;

import br.com.fumec.models.Pessoa;

public interface IPessoaDAO extends Serializable {
	
	public List<Pessoa> findAll();
		
}