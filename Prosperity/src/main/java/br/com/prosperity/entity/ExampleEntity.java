package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TbExample")
public class ExampleEntity {
	/* Mapeamento do ID */
	@Id
	@Column(name = "idExample", unique = true, nullable = false)
	private Integer Id;
	/* fim Id */

	@Column(name = "nmExample")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
