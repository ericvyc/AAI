package br.com.fumec.models;

import java.io.Serializable;

public class Endereco implements Serializable {

	private static final long serialVersionUID = 247815236006501283L;

	private int id;

	private String logradouro;

	private String complemento;

	private Cidade cidade;

	private Estado estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Endereco(int id, String logradouro, String complemento, Cidade cidade, Estado estado) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Endereco() {
		super();
	}

}