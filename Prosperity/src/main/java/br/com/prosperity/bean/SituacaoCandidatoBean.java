package br.com.prosperity.bean;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.prosperity.enumarator.StatusCandidatoEnum;

@Component
public class SituacaoCandidatoBean {

	private Integer idCandidato;
	private StatusCandidatoEnum status;
	private String parecer;
	private String proposta;
	private ProvaCandidatoBean processoSeletivo;
	private String parecerTecnico;
	private List<CandidatoCompetenciaBean> avaliacoesCompetencias;

	public Integer getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}

	public StatusCandidatoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusCandidatoEnum status) {
		this.status = status;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public void setIdStatus(Integer idStatus) {
		status = StatusCandidatoEnum.valueOf(idStatus);
	}

	public String getProposta() {
		return proposta;
	}

	public void setProposta(String proposta) {
		this.proposta = proposta;
	}

	public ProvaCandidatoBean getProcessoSeletivo() {
		return processoSeletivo;
	}

	public void setProcessoSeletivo(ProvaCandidatoBean processoSeletivo) {
		this.processoSeletivo = processoSeletivo;
	}

	public String getParecerTecnico() {
		return parecerTecnico;
	}

	public void setParecerTecnico(String parecerTecnico) {
		this.parecerTecnico = parecerTecnico;
	}

	public List<CandidatoCompetenciaBean> getAvaliacoesCompetencias() {
		return avaliacoesCompetencias;
	}

	public void setAvaliacoesCompetencias(List<CandidatoCompetenciaBean> avaliacoesCompetencias) {
		this.avaliacoesCompetencias = avaliacoesCompetencias;
	}
	
	

}
