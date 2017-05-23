package br.com.prosperity.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "StatusCandidatoBean")
public class StatusCandidatoBean {

	private Integer id;
	private Date dataAlteracao;
	private String descricaoParecer;
	private Boolean situacao;
	private UsuarioBean usuario;
	private StatusBean status;
	private String mensagem;
	private CancelamentoBean cancelamento;
	private String dsCancelamento;

	public StatusCandidatoBean() {
	}

	public StatusCandidatoBean(String mensagem) {
		status = new StatusBean();
		status.setNome(mensagem);
	}

	public String getMesAno() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM/yyyy");
		return dateFormat.format(dataAlteracao);
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

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

	public CancelamentoBean getCancelamento() {
		return cancelamento;
	}

	public void setCancelamento(CancelamentoBean cancelamento) {
		this.cancelamento = cancelamento;
	}

	public String getDsCancelamento() {
		return dsCancelamento;
	}

	public void setDsCancelamento(String dsCancelamento) {
		this.dsCancelamento = dsCancelamento;
	}
}