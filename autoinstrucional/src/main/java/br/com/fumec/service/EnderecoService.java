package br.com.fumec.service;

import java.io.Serializable;

import br.com.fumec.models.Endereco;

public interface EnderecoService extends Serializable {
	
	public Endereco getEnderecoById(Integer idEndereco);
	
	public void createEndereco(Endereco endereco);
	
}
