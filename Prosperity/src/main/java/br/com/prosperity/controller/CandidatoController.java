package br.com.prosperity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.business.CandidatoBusiness;

@Controller
@RequestMapping(value="candidato")
public class CandidatoController {
	
	@Autowired
	private CandidatoBusiness candidatoBusiness;
	
	@RequestMapping(value ="cadastrar", method = RequestMethod.GET)
	public String cadastrarCandidato() {
		return "candidato/cadastrar-candidato";
	}
	
	@RequestMapping(value ="consultar-rh", method = RequestMethod.GET)
	public String consultarCandidatoRH() {
		return "candidato/consulta-rh";
	}
	
	@RequestMapping(value ="consultar-gestor", method = RequestMethod.GET)
	public String consultarCandidatoGestor() {
		return "candidato/consulta-gestor";
	}
	
	@RequestMapping(value ="historico", method = RequestMethod.GET)
	public String historicoCandidato() {
		CandidatoBean candidatoBean = null;
		candidatoBean = candidatoBusiness.obter(1);
		
		return "candidato/historico-candidato";
	}
}
