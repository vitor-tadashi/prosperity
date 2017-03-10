package br.com.prosperity.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbFuncionario")
public class FuncionarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFuncionario", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="nmFuncionario")
	private String nome;

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
	
}
