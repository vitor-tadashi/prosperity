package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbProvaCandidato")
public class ProvaCandidatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProvaCandidato", unique = true, nullable = false)
	private Integer id;

	@Column(name = "idDescricaoProva")
	@OneToMany(fetch=FetchType.LAZY)
	private List<DescricaoProvaEntity> descricaoProvas;

	@Column(name = "idProva")
	@OneToMany(fetch=FetchType.LAZY)
	private List<ProvaEntity> provas;

	@Column(name = "dsParecerTecnico")
	private String parecer;

	@OneToOne
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;

	public List<DescricaoProvaEntity> getDescricaoProvas() {
		return descricaoProvas;
	}

	public void setDescricaoProvas(List<DescricaoProvaEntity> descricaoProvas) {
		this.descricaoProvas = descricaoProvas;
	}

	public List<ProvaEntity> getProvas() {
		return provas;
	}

	public void setProvas(List<ProvaEntity> provas) {
		this.provas = provas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}

}
