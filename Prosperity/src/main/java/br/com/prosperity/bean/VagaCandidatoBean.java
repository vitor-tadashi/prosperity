package br.com.prosperity.bean;

import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "VagaCandidatoBean")
public class VagaCandidatoBean {

	@Min(value = 1, message = "O campo de vaga a ser aplicado deve ser preenchido")
	private Integer id;

	private VagaBean vaga;
	private String outros;
	private FuncionarioBean funcionarioBean;
	private CanalInformacaoBean canalInformacao;
	private CandidatoBean candidatoBean;
	private Boolean contratado;

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
	}

	public FuncionarioBean getFuncionarioBean() {
		return funcionarioBean;
	}

	public void setFuncionarioBean(FuncionarioBean funcionarioBean) {
		this.funcionarioBean = funcionarioBean;
	}

	public Boolean getContratado() {
		return contratado;
	}

	public void setContratado(Boolean contratado) {
		this.contratado = contratado;
	}

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

	public CanalInformacaoBean getCanalInformacao() {
		return canalInformacao;
	}

	public void setCanalInformacao(CanalInformacaoBean canalInformacao) {
		this.canalInformacao = canalInformacao;
	}

	public CandidatoBean getCandidatoBean() {
		return candidatoBean;
	}

	public void setCandidatoBean(CandidatoBean candidatoBean) {
		this.candidatoBean = candidatoBean;
	}
}