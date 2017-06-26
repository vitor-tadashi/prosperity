package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class FuncionalidadeBean {
	private Integer id;
	private String nome;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.id == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		FuncionalidadeBean id = (FuncionalidadeBean) obj;
		if (this.id == null) {
			if (id.getId() != null) {
				return false;
			}
		} else if (!this.id.equals(id.getId())) {
			return false;
		}
		return true;
	}
}