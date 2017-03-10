package br.com.prosperity.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FuncionalidadeBean {
	private Integer id;
	private String nome;
	private List<PerfilBean> perfil;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<PerfilBean> getPerfil() {
		return perfil;
	}
	public void setPerfil(List<PerfilBean> perfil) {
		this.perfil = perfil;
	}
}
