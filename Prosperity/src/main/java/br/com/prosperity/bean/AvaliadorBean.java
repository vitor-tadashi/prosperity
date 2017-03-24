package br.com.prosperity.bean;

import org.springframework.stereotype.Component;

@Component
public class AvaliadorBean {
	private Integer idAvaliador;
	private Boolean status;
	private UsuarioBean usuario;
	private VagaBean vaga;

	public Integer getIdAvaliador() {
		return idAvaliador;
	}

	public void setIdAvaliador(Integer idAvaliador) {
		this.idAvaliador = idAvaliador;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public VagaBean getVaga() {
		return vaga;
	}

	public void setVaga(VagaBean vaga) {
		this.vaga = vaga;
	}
}
