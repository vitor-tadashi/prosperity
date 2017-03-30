package br.com.prosperity.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WordpressBean")
public class WordpressBean {
	private List<CandidatoWordPressBean> candidatosWordPress = new ArrayList<>();
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