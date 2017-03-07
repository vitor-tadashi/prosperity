package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("relatorio")
public class RelatorioController {
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String relatorio() {
		return "relatorio/gerar-relatorio";
	}

}
