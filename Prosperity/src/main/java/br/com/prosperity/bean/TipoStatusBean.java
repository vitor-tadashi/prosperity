package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class TipoStatusBean {

	private Integer id;
	private String Status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
