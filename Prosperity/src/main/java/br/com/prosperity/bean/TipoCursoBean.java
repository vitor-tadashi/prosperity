package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

public class TipoCursoBean {

	private int idTipoCurso;
	private String nmTipoCurso;

	public TipoCursoBean(int idTipoCurso, String nmTipoCurso) {
		this.idTipoCurso = idTipoCurso;
		this.nmTipoCurso = nmTipoCurso;
	}

	public TipoCursoBean() {

	}

	public int getIdTipoCurso() {
		return idTipoCurso;
	}

	public void setIdTipoCurso(int idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}

	public String getNmTipoCurso() {
		return nmTipoCurso;
	}

	public void setNmTipoCurso(String nmTipoCurso) {
		this.nmTipoCurso = nmTipoCurso;
	}



}
