package br.com.prosperity.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class StatusCandidatoBean {

	private Integer id;
	private Date dataAlteracao;
	private String descricaoParecer;
	//private CandidatoBean candidato;
	private UsuarioBean usuario;
	private StatusBean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

//	public CandidatoBean getCandidato() {
//		return candidato;
//	}
//
//	public void setCandidato(CandidatoBean candidato) {
//		this.candidato = candidato;
//	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public StatusBean getStatus() {
		return status;
	}

	public void setStatus(StatusBean status) {
		this.status = status;
	}

}
