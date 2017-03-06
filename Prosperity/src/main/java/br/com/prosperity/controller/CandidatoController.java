package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="candidato")
public class CandidatoController {
	
	@RequestMapping(value ="cadastrar", method = RequestMethod.GET)
	public String cadastrarCandidato() {
		return "cadastrar-candidato";
	}
	
	@RequestMapping(value ="consulta-rh", method = RequestMethod.GET)
	public String consultarCandidatoRH() {
		return "consulta-rh";
	}
	
	@RequestMapping(value ="consulta-gestor", method = RequestMethod.GET)
	public String consultarCandidatoGestor() {
		return "consulta-gestor";
	}
	
	@RequestMapping(value ="historico", method = RequestMethod.GET)
	public String historicoCandidato() {
		return "historico-candidato";
	}
}
