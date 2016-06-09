package br.com.fumec.dao;

import java.io.Serializable;

import br.com.fumec.models.Endereco;

public interface IEnderecoDAO extends Serializable {
	
	public Endereco getEnderecoById(Integer idEndereco);
	
	public void createEndereco(Endereco endereco);

}
