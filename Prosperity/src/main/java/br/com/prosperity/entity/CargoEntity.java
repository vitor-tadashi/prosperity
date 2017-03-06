package br.com.prosperity.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbCargo")


public class CargoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="idCargo", unique = true, nullable = false)
	private int id;
	@Column(name = "nmCargo")
	private String nome;
	
	public CargoEntity(){
		
	}
	
	public CargoEntity(int id, String nome){
		this.id=id;
		this.nome=nome;
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

	public void setNome(String nome) {
		this.nome = nome;
	}
}
