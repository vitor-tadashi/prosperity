package br.com.prosperity.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class StatusVagaBean {

	public StatusVagaBean(String mensagem) {
		status = new StatusBean();
		status.setNome(mensagem);
	}

	public StatusVagaBean() {

	}

	private Integer id;
	private StatusBean status;
	private Date dataAlteracao;
	private Integer vagaBean;
	private UsuarioBean usuarioBean;

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

	public StatusBean getStatus() {
		return status;
	}

	public void setStatus(StatusBean statusBean) {
		this.status = statusBean;
	}

	public Integer getVagaBean() {
		return vagaBean;
	}

	public void setVagaBean(Integer vagaBean) {
		this.vagaBean = vagaBean;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}
}
