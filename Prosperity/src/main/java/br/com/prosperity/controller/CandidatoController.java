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
	
	@RequestMapping(value ="consultar-rh", method = RequestMethod.GET)
	public String consultarCandidatoRH() {
		return "consultar-rh";
	}
}
