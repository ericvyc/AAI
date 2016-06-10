package br.com.fumec.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_pessoa")
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 7309878492055471213L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="nome")
	private String nome;
	
	@Column(name="idade")
	private int idade;

	public Pessoa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}