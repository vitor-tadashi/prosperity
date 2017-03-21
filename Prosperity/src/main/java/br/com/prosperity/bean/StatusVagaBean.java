package br.com.prosperity.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class StatusVagaBean {

	private Integer id;
	private StatusBean statusBean;
	private Date dataAlteracao;
	private VagaBean vagaBean;

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

	public StatusBean getStatusBean() {
		return statusBean;
	}

	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}
	
	public VagaBean getVagaBean() {
		return vagaBean;
	}

	public void setVagaBean(VagaBean vagaBean) {
		this.vagaBean = vagaBean;
	}

}
