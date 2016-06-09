package br.com.fumec.models;

import java.io.Serializable;

public class Estado implements Serializable {

	private static final long serialVersionUID = -2638331931178243565L;

	private int id;

	private String nome;

	private String sigla;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Estado(int id, String nome, String sigla) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Estado() {
		super();
	}

}