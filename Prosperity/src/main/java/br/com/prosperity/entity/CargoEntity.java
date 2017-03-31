package br.com.prosperity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbCargo")
public class CargoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCargo", unique = true, nullable = false)
	private Integer idCargo;
	
	@Column(name = "nmCargo")
	private String nome;
	
/*//	@ManyToOne
//	@JoinColumn(name = "idCargoSenoridade")
//	private CargoSenioridadeEntity cargoSenioridade; //relacionamento entre Senioridade e Cargo
//
//	public CargoSenioridadeEntity getSenioridade() {
//		return cargoSenioridade;
//	}
//
//	public void setSenioridade(CargoSenioridadeEntity cargoSenioridade) {
//		this.cargoSenioridade = cargoSenioridade;
//	}
*/
	public Integer getId() {
		return idCargo;
	}

	public void setId(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
