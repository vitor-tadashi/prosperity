package br.com.prosperity.bean;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "VagaCandidatoBean")
public class VagaCandidatoBean {
	
	@Min(value = 1, message = "O campo de vaga a ser aplicado deve ser preenchido")
	private Integer id;
	
	@Valid
	private VagaBean vaga;
		
	private CanalInformacaoBean canalInformacao;
	
	private CandidatoBean candidatoBean;
	
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
