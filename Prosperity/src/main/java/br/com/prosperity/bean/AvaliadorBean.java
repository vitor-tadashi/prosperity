package br.com.prosperity.bean;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class AvaliadorBean {
	private Integer idAvaliador;
	
	public AvaliadorBean() {
		
	}
	
	public AvaliadorBean(Integer idAvaliador) {
		super();
		this.idAvaliador = idAvaliador;
	}

	public Integer getIdAvaliador() {
		return idAvaliador;
	}

	public void setIdAvaliador(Integer idAvaliador) {
		this.idAvaliador = idAvaliador;
	}
	
	
}
