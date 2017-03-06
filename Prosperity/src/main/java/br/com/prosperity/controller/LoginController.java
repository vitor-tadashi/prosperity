package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value ="login", method = RequestMethod.GET)
	public String indexLogin() {
		return "acesso";
	}
	@RequestMapping(value ="primeiro-acesso", method = RequestMethod.GET)
	public String primeiroAcessoUsuario(){
		return "primeiro-acesso";
	}
}
