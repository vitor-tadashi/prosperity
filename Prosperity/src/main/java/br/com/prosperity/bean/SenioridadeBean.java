package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

public class SenioridadeBean {

	private int idSenioridade;
	private String nmSenioridade;

	public SenioridadeBean(int idSenioridade, String nmSenioridade) {

		this.idSenioridade = idSenioridade;
		this.nmSenioridade = nmSenioridade;
	}

	public SenioridadeBean() {

	}

	public int getIdSenioridade() {
		return idSenioridade;
	}

	public void setIdSenioridade(int idSenioridade) {
		this.idSenioridade = idSenioridade;
	}

	public String getNmSenioridade() {
		return nmSenioridade;
	}

	public void setNmSenioridade(String nmSenioridade) {
		this.nmSenioridade = nmSenioridade;
	}



}
