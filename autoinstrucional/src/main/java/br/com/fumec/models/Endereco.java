package br.com.fumec.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/* Entidade endereço e seus atributos */
@Entity
@Table(name="tb_endereco")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 247815236006501283L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@Column(name="logradouro")
	private String logradouro;

	@Column(name="complemento")
	private String complemento;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_cidade")
	private Cidade cidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_estado")
	private Estado estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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