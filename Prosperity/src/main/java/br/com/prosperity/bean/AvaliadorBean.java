package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class AvaliadorBean {
	private Integer idAvaliador;

	public Integer getIdAvaliador() {
		return idAvaliador;
	}

	public void setIdAvaliador(Integer idAvaliador) {
		this.idAvaliador = idAvaliador;
	}

}
