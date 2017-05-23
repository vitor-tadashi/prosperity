package br.com.prosperity.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "StatusVagaBean")
public class StatusVagaBean {

	private Integer id;
	private StatusBean status;
	private Date dataAlteracao;
	private VagaBean vagaBean;
	private UsuarioBean usuarioBean;
	private boolean situacao;

	public StatusVagaBean() {
	}

	public StatusVagaBean(String mensagem) {
		status = new StatusBean();
		status.setNome(mensagem);
	}

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

	public VagaBean getVagaBean() {
		return vagaBean;
	}

	public void setVagaBean(VagaBean vagaBean) {
		this.vagaBean = vagaBean;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
}