package br.com.prosperity.bean;

import java.util.Date;

public class StatusVagaBean {

	private int idStatus;
	private String idVaga;
	private Date dataAlteracao;
	
	
	public StatusVagaBean(int idStatus, String idVaga, Date dataAlteracao) {
		this.idStatus = idStatus;
		this.idVaga = idVaga;
		this.dataAlteracao = dataAlteracao;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
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
