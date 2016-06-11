package br.com.fumec.dao;

import java.io.Serializable;
import java.util.List;

import br.com.fumec.models.Estado;

/* Interface de métodos de acesso a base de dados para Estado */
public interface IEstadoDAO extends Serializable {

	public Estado createEstado(Estado estado);
	
	public List<Estado> findAll();
	
	public Estado update(Estado estado);
	
	public void delete(Integer id);
	
	public void deletarTodos();
	
}
