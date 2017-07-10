package br.com.prosperity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbVagaCandidato")
@NamedQueries({
		@NamedQuery(name = "countCandidatosVaga", query = "SELECT count(vc) FROM VagaCandidatoEntity vc WHERE vc.vaga.id = 1200"),
		@NamedQuery(name = "candidatosVaga", query = "SELECT vc FROM VagaCandidatoEntity vc WHERE vc.vaga.id = ?1"),
		@NamedQuery(name = "candidatoContratado", query = "SELECT cc FROM VagaCandidatoEntity cc WHERE cc.candidato.id = ?1 ORDER BY cc.idVagaCandidato ASC") })
public class VagaCandidatoEntity {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	@Column(name = "idVagaCandidato", unique = true, nullable = false)
	private Integer idVagaCandidato;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "idVaga")
	private VagaEntity vaga;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "idCanalInformacao")
	private CanalInformacaoEntity canalInformacao;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idCandidato")
	private CandidatoEntity candidato;

	@Column(name = "contratado")
	private Boolean contratado;

	@Column(name = "dsOutros")
	private String outros;
	
	@Column(name = "nmFuncionario")
	private String nmFuncionario;
	
	@Column(name = "situacao")
	private Boolean situacao;

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
	}

	public String getNmFuncionario() {
		return nmFuncionario;
	}

	public void setNmFuncionario(String nmFuncionario) {
		this.nmFuncionario = nmFuncionario;
	}

	public Boolean getContratado() {
		return contratado;
	}

	public void setContratado(Boolean contratado) {
		this.contratado = contratado;
	}

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

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}
}