package br.com.prosperity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbVagaCandidato")
public class VagaCandidatoEntity {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idVagaCandidato", unique = true, nullable = false)
	private Integer idVagaCandidato;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;

	@OneToOne(cascade = CascadeType.REFRESH, fetch=FetchType.LAZY)
	@JoinColumn(name = "idCanalInformacao")
	private CanalInformacaoEntity canalInformacao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;
	
	public Integer getIdVagaCandidato() {
		return idVagaCandidato;
	}

	public void setIdVagaCandidato(Integer idVagaCandidato) {
		this.idVagaCandidato = idVagaCandidato;
	}

	public VagaEntity getVaga() {
		return vaga;
	}

	public void setVaga(VagaEntity vaga) {
		this.vaga = vaga;
	}

	public CanalInformacaoEntity getCanalInformacao() {
		return canalInformacao;
	}

	public void setCanalInformacao(CanalInformacaoEntity canalInformacao) {
		this.canalInformacao = canalInformacao;
	}

	public CandidatoEntity getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoEntity candidato) {
		this.candidato = candidato;
	}

}
