package br.com.fumec.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tb_endereco database table.
 * 
 */
@Entity
@Table(name="tb_endereco")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String complemento;

	private String logradouro;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade tbCidade;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado tbEstado;

	public Endereco() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Cidade getTbCidade() {
		return this.tbCidade;
	}

	public void setTbCidade(Cidade tbCidade) {
		this.tbCidade = tbCidade;
	}

	public Estado getTbEstado() {
		return this.tbEstado;
	}

	public void setTbEstado(Estado tbEstado) {
		this.tbEstado = tbEstado;
	}

	public Endereco(int id, String complemento, String logradouro, Cidade tbCidade, Estado tbEstado) {
		super();
		this.id = id;
		this.complemento = complemento;
		this.logradouro = logradouro;
		this.tbCidade = tbCidade;
		this.tbEstado = tbEstado;
	}

}