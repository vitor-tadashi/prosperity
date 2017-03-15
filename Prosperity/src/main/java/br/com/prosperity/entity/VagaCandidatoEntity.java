package br.com.prosperity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbVagaCandidato")
public class VagaCandidatoEntity {
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idVagaCandidato", unique = true, nullable = false)
	private Integer idVagaCandidato;
	@OneToOne
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;
	@OneToMany
	@JoinColumn(name = "idCandidato")
	private List<CandidatoEntity> candidato;
	@OneToOne
	@JoinColumn(name = "idCanalInofrmacao")
	private CanalInformacaoEntity canalInformacao;

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

	public List<CandidatoEntity> getCandidato() {
		return candidato;
	}

	public void setCandidato(List<CandidatoEntity> candidato) {
		this.candidato = candidato;
	}

	public CanalInformacaoEntity getCanalInformacao() {
		return canalInformacao;
	}

	public void setCanalInformacao(CanalInformacaoEntity canalInformacao) {
		this.canalInformacao = canalInformacao;
	}

}
