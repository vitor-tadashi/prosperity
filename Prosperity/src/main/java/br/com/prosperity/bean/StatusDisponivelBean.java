package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class StatusDisponivelBean {

	private Integer id;
	private Integer idStatusDisponivel;
	private String nome;
	private String classe;

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdStatusDisponivel() {
		return idStatusDisponivel;
	}

	public void setIdStatusDisponivel(Integer idStatusDisponivel) {
		this.idStatusDisponivel = idStatusDisponivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}