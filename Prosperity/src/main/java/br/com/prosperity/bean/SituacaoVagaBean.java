package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

import br.com.prosperity.enumarator.StatusVagaEnum;

@Component
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
	public void setIdStatus(Integer idStatus){
		status = StatusVagaEnum.valueOf(idStatus);
	}
}
