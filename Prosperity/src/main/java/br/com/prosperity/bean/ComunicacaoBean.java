package br.com.prosperity.bean;

import java.sql.Date;

public class ComunicacaoBean {
	
	private Integer id;
	private Date dataContato;
	private String observacao;
	private UsuarioBean usuarioBean;
	private CandidatoBean candidatoBean;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataContato() {
		return dataContato;
	}
	public void setDataContato(Date dataContato) {
		this.dataContato = dataContato;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String oberservacao) {
		this.observacao = oberservacao;
	}
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}
	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}
	public CandidatoBean getCandidatoBean() {
		return candidatoBean;
	}
	public void setCandidatoBean(CandidatoBean candidatoBean) {
		this.candidatoBean = candidatoBean;
	}

}
