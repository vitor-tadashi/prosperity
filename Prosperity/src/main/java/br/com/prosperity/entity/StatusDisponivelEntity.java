package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbStatusDisponivel")
public class StatusDisponivelEntity {
	
	@Id
	@Column(name="idStatusDisponivel")
	private Integer id;
	
	@Column(name = "nmOpcao")
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
