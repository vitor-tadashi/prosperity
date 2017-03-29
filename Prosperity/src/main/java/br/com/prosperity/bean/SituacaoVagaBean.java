package br.com.prosperity.bean;

import br.com.prosperity.enumarator.StatusVagaEnum;

public class SituacaoVagaBean {
	
	private Integer idVaga;
	private StatusVagaEnum status;

	public Integer getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Integer idVaga) {
		this.idVaga = idVaga;
	}

	public StatusVagaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusVagaEnum status) {
		this.status = status;
	}

}
