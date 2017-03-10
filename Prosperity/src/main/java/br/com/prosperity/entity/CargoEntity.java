package br.com.prosperity.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbCargo")


public class CargoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idCargo", unique = true, nullable = false)
	private Integer id;
	@Column(name = "nmCargo")
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
