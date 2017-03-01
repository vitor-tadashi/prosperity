package br.com.prosperity.entity;

import java.util.List;

public class PermicaoEntity {
	private int id;
	private String nome;
	private List<PerfilEntity> perfil;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<PerfilEntity> getPerfil() {
		return perfil;
	}
	public void setPerfil(List<PerfilEntity> perfil) {
		this.perfil = perfil;
	}
}
