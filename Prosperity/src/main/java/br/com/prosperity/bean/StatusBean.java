package br.com.prosperity.bean;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class StatusBean {

	private Integer id;
	private String nome;
	private String css;
	private TipoStatusBean tipo;
	private Set<StatusDisponivelBean> statusDisponiveis;
	
	public StatusBean() {
		statusDisponiveis = new HashSet<StatusDisponivelBean>();
	}

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

	public TipoStatusBean getTipo() {
		return tipo;
	}

	public void setTipo(TipoStatusBean tipo) {
		this.tipo = tipo;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public Set<StatusDisponivelBean> getStatusDisponiveis() {
		return statusDisponiveis;
	}

	public void setStatusDisponiveis(Set<StatusDisponivelBean> statusDisponiveis) {
		this.statusDisponiveis = statusDisponiveis;
	}
	
}
