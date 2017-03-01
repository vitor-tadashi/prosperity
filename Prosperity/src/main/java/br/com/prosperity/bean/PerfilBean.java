package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

public class PerfilBean {

	private int idPerfil;
	private String nmPerfil;
	private int idAvaliador;

	public PerfilBean(int id, String nmPerfil, int idAvaliador) {
		this.idPerfil = idPerfil;
		this.nmPerfil = nmPerfil;
		this.idAvaliador = idAvaliador;
	}

	public PerfilBean() {

	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNmPerfil() {
		return nmPerfil;
	}

	public void setNmPerfil(String nmPerfil) {
		this.nmPerfil = nmPerfil;
	}


	public int getIdAvaliador() {
		return idAvaliador;
	}

	public void setIdAvaliador(int idAvaliador) {
		this.idAvaliador = idAvaliador;
	}
}
