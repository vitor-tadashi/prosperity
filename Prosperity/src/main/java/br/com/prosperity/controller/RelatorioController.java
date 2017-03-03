package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RelatorioController {
	@RequestMapping(value ="/testes", method = RequestMethod.GET)
	public String relatorio() {
		return "gerar";
	}

}
