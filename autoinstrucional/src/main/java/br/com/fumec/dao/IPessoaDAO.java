package br.com.fumec.dao;

import java.io.Serializable;
import java.util.List;

import br.com.fumec.models.Pessoa;

/* Interface de métodos de acesso a base de dados para Pessoa */
public interface IPessoaDAO extends Serializable {
	
	public List<Pessoa> findAll();
	
	public Pessoa findOne(Integer id);
		
	public Pessoa create(Pessoa pessoa);

	public Pessoa update(Pessoa pessoa);
	
	public void delete(Integer id);
	
	public void deleteAll();
}