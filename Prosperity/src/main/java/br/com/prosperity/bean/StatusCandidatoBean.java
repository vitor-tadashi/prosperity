package br.com.prosperity.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class StatusCandidatoBean {

	public StatusCandidatoBean() {
		
	}
	
	public StatusCandidatoBean(String mensagem) {
		status = new StatusBean();
		status.setNome(mensagem);
	}

	private Integer id;
	private Date dataAlteracao;
	private String descricaoParecer;
	private UsuarioBean usuario;
	private StatusBean status;
	
	public String getMesAno() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM/yyyy");
		return dateFormat.format(dataAlteracao);
	}
	
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getDescricaoParecer() {
		return descricaoParecer;
	}

	public void setDescricaoParecer(String descricaoParecer) {
		this.descricaoParecer = descricaoParecer;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public StatusBean getStatus() {
		return status;
	}

	public void setStatus(StatusBean status) {
		this.status = status;
	}

}
