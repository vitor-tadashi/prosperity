package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

import br.com.prosperity.enumarator.StatusCandidatoEnum;

@Component
public class SituacaoCandidatoBean {

	private Integer idCandidato;
	private StatusCandidatoEnum status;
	private String parecer;

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
}
