package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "candidato")
public class PerfilController {

	@RequestMapping(value = "nome", method = RequestMethod.GET)
	public String nomePerfil() {
		return "nomePerfil";
	}

	@RequestMapping(value = "idAvaliador", method = RequestMethod.GET)
	public String idAvaliador() {
		return "idAvaliador";
	}
}
