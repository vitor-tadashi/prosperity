package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class AvaliadorCandidatoBean {

	private Integer id;
	private CandidatoBean candidato;
	private AvaliadorVagaBean avaliadorVaga;
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CandidatoBean getCandidato() {
		return candidato;
	}

	public void setCandidato(CandidatoBean candidato) {
		this.candidato = candidato;
	}

	public AvaliadorVagaBean getAvaliadorVaga() {
		return avaliadorVaga;
	}

	public void setAvaliadorVaga(AvaliadorVagaBean avaliadorVaga) {
		this.avaliadorVaga = avaliadorVaga;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
