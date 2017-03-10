package br.com.prosperity.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tbSenioridade")
public class SenioridadeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSenioridade", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="nmSenioridade")
	private String nome;
	
	 @ManyToMany
	 @JoinTable(name="tbCargoSenioridade", joinColumns={@JoinColumn(name="idCargo")}, inverseJoinColumns={@JoinColumn(name="idSenioridade")})
	private List<CargoEntity> senioridade; //relacionamento entre Senioridade e CargoBeana

	public List<CargoEntity> getSenioridade() {
		return senioridade;
	}

	public void setSenioridade(List<CargoEntity> senioridade) {
		this.senioridade = senioridade;
	}

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
