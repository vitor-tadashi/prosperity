package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("vaga")
public class VagaController {
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String cliente() {
		return "vaga/consultar-vaga";
	}

	@RequestMapping(value = "/aprovar", method = RequestMethod.GET)
	public String aprovacaoVaga() {
		return "vaga/aprovacao-vaga";
	}
	@RequestMapping (value= "/solicitar", method = RequestMethod.GET)
	public String solicitarVaga(){
		return "vaga/solicitar-vaga";
	}
}
