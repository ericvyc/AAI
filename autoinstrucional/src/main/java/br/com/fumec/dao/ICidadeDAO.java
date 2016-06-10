package br.com.fumec.dao;

import java.io.Serializable;
import java.util.List;

import br.com.fumec.models.Cidade;

public interface ICidadeDAO extends Serializable {

	public Cidade createCidade(Cidade cidade);
	
	public List<Cidade> findAll();
	
	public Cidade update(Cidade cidade);
	
	public void delete(Integer id);
	
	public void deletarTodos();
	
}