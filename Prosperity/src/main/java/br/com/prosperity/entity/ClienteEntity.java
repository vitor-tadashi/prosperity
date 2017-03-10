package br.com.prosperity.entity;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CargoSenioridade
 *
 */

@Entity
@Table(name="tbCliente")

public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCliente", unique = true)
	private Integer id;
	
	@Column(name="nmCliente")
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

	public void setNome(String nmCliente) {
		this.nome = nmCliente;
	}

}
