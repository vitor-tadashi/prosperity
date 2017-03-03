package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VagaController {
	@RequestMapping(value = "/consultar-vaga", method = RequestMethod.GET)
	public String cliente() {
		return "consultar-vaga";
	}

	@RequestMapping(value = "/aprovacao-vaga", method = RequestMethod.GET)
	public String aprovacaoVaga() {

		return "aprovacao-vaga";
	}
	@RequestMapping (value= "/solicitar-vaga", method = RequestMethod.GET)
	public String solicitarVaga(){
		return "solicitar-vaga";
	}
}
