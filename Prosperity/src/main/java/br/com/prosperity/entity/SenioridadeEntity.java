package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbSenioridade")
public class SenioridadeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSenioridade", unique = true, nullable = false)
	private Integer idSenioridade;

	@Column(name = "nmSenioridade")
	private String nome;

	public Integer getId() {
		return idSenioridade;
	}

	public void setId(Integer idSenioridade) {
		this.idSenioridade = idSenioridade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}