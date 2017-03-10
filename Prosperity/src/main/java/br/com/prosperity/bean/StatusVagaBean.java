package br.com.prosperity.bean;

import java.util.Date;

public class StatusVagaBean {

	private Integer idStatus;
	private String idVaga;
	private Date dataAlteracao;
	
	public Integer getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}
	public String getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(String idVaga) {
		this.idVaga = idVaga;
	}
	public Date getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
}
