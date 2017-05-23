package br.com.prosperity.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.prosperity.util.CustomerDateAndTimeDeserialize;


@JsonRootName(value = "WordpressBean")
@JsonDeserialize(using=CustomerDateAndTimeDeserialize.class)
public class WordpressBean {
	
	@JsonIgnore
	private List<CandidatoWordPressBean> candidatosWordPress;

	private List<CandidatoBean> candidatos;

	public WordpressBean(List<CandidatoBean> candidatos) {
		super();
		this.candidatos = candidatos;
	}

	public WordpressBean() {
	}

	@XmlElement(type = CandidatoBean.class)
	public List<CandidatoBean> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<CandidatoBean> candidatos) {
		this.candidatos = candidatos;
	}


	@XmlElement(type = CandidatoWordPressBean.class)
	public List<CandidatoWordPressBean> getCandidatosWordPress() {
		return candidatosWordPress;
	}

	public void setCandidatosWordPress(List<CandidatoWordPressBean> candidatosWordPress) {
		this.candidatosWordPress = candidatosWordPress;
	}

}