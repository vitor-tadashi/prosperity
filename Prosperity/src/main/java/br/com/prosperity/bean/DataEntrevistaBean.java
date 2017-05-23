package br.com.prosperity.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class DataEntrevistaBean {

	private Integer id;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataEntrevista;
	private UsuarioBean usuario;
	private VagaBean vaga;
	private Integer candidato;
	private Boolean flSituacao = true;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEntrevista() {
		return dataEntrevista;
	}

	public void setDataEntrevista(Date dataEntrevista) {
		this.dataEntrevista = dataEntrevista;
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

	public Integer getCandidato() {
		return candidato;
	}

	public void setCandidato(Integer candidato) {
		this.candidato = candidato;
	}

	public Boolean getFlSituacao() {
		return flSituacao;
	}

	public void setFlSituacao(Boolean flSituacao) {
		this.flSituacao = flSituacao;
	}

}
