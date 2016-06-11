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

@Entity
@Table(name="tb_cidade")
@NamedQuery(name="Cidade.findAll", query="SELECT e FROM Cidade e")
public class Cidade implements Serializable {

	private static final long serialVersionUID = -1255499823141568183L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@Column(name="nome")
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_estado")
	private Estado estado;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade(int id, String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public Cidade() {
		super();
	}


}