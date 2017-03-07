package br.com.prosperity.entity;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CargoSenioridade
 *
 */

@Entity
@Table(name="tbCargoSenioridade")

public class CargoSenioridadeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idCargoSenioridade", unique = true)
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCargo")
	private CargoEntity idCargo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "idSenioridade")
	private SenioridadeEntity idSenioridade;
	
	@Column(name="vlMinSalario")
	private double vlMinSalario;
	
	@Column(name="vlMaxSalario")
	private double vlMaxSalario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CargoEntity getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(CargoEntity idCargo) {
		this.idCargo = idCargo;
	}
	public SenioridadeEntity getIdSenioridade() {
		return idSenioridade;
	}
	public void setIdSenioridade(SenioridadeEntity idSenioridade) {
		this.idSenioridade = idSenioridade;
	}
	public double getVlMinSalario() {
		return vlMinSalario;
	}
	public void setVlMinSalario(double vlMinSalario) {
		this.vlMinSalario = vlMinSalario;
	}
	public double getVlMaxSalario() {
		return vlMaxSalario;
	}
	public void setVlMaxSalario(double vlMaxSalario) {
		this.vlMaxSalario = vlMaxSalario;
	}
	
}
