package br.com.prosperity.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tbSenioridade")
public class SenioridadeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idSenioridade", unique = true, nullable = false)
	private int id;
	@Column(name="nmSenioridade")
	private String descricao;
	
	 @ManyToMany
	 @JoinTable(name="tbCargoSenioridade", joinColumns={@JoinColumn(name="idCargo")}, inverseJoinColumns={@JoinColumn(name="idSenioridade")})
	private List<CargoEntity> senioridade; //relacionamento entre Senioridade e CargoBeana

	public List<CargoEntity> getSenioridade() {
		return senioridade;
	}

	public void setSenioridade(List<CargoEntity> senioridade) {
		this.senioridade = senioridade;
	}

	public SenioridadeEntity(int id, String descricao) {

		this.id = id;
		this.descricao = descricao;
	}

	public SenioridadeEntity() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
