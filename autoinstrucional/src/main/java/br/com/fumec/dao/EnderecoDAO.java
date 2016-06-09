package br.com.fumec.dao;

import br.com.fumec.models.Endereco;

public interface EnderecoDAO {
	
	public Endereco getEnderecoById(Integer idEndereco);
	
	public void createEndereco(Endereco endereco);

}
