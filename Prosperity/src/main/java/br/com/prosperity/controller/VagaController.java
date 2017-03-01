package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class VagaController {
	@RequestMapping("/tela")
	public String tela(){
		return "consultar-vaga";
	}
}
