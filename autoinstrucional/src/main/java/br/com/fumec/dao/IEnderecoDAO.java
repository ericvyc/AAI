package br.com.fumec.dao;

import java.io.Serializable;
import java.util.List;

import br.com.fumec.models.Endereco;

/* Interface de métodos de acesso a base de dados para Endereço */
public interface IEnderecoDAO extends Serializable {
	
	public Endereco createEndereco(Endereco endereco);
	
	public List<Endereco> findAll();
	
	public Endereco update(Endereco endereco);
	
	public void delete(Integer id);
	
	public void deletarTodos();

}
