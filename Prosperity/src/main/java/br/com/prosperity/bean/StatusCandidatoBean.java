package br.com.prosperity.bean;

import java.util.Date;

public class StatusCandidatoBean {
	
	private int id;
	private String cpf;
	private Date dataAlteracao;
	private String descricaoParecer;
	
	
	public StatusCandidatoBean(int id, String cpf, Date dataAlteracao, String descricaoParecer) {
		this.id = id;
		this.cpf = cpf;
		this.dataAlteracao = dataAlteracao;
		this.descricaoParecer = descricaoParecer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public String getDescricaoParecer() {
		return descricaoParecer;
	}
	public void setDescricaoParecer(String descricaoParecer) {
		this.descricaoParecer = descricaoParecer;
	}
	
	

}
