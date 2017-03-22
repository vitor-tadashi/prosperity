package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class StatusFuturoBean {
	private Integer id;
	private StatusBean status;
	private StatusBean statusFuturo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusBean getStatus() {
		return status;
	}

	public void setStatus(StatusBean status) {
		this.status = status;
	}

	public StatusBean getStatusFuturo() {
		return statusFuturo;
	}

	public void setStatusFuturo(StatusBean statusFuturo) {
		this.statusFuturo = statusFuturo;
	}
}
