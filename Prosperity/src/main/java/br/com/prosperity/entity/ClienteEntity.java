package br.com.prosperity.entity;

import javax.persistence.*;

@Entity
@Table(name="tbCliente")

public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCliente", unique = true)
	private int id;
	
	@Column(name="nmCliente")
	private String nome;

	public ClienteEntity(int id, String nmCliente) {
		this.id = id;
		this.nome = nmCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nmCliente) {
		this.nome = nmCliente;
	}

}
