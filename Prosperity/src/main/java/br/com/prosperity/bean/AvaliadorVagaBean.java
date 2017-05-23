package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class AvaliadorVagaBean {
	private Integer id;
	private VagaBean vaga;
	private UsuarioBean usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VagaBean getVaga() {
		return vaga;
	}

	public void setVaga(VagaBean vaga) {
		this.vaga = vaga;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
}