package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("usuario")
public class UsuarioController {
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String indexLogin() {
		return "acesso";
	}
	@RequestMapping(value ="/primeiro-acesso", method = RequestMethod.GET)
	public String primeiroAcessoUsuario(){
		return "primeiro-acesso";
	}
	@RequestMapping(value ="/consulta", method = RequestMethod.GET)
	public String consultaUsuario(){
		return "consultar-usuario";
	}
	@RequestMapping(value ="/cria-perfil", method = RequestMethod.GET)
	public String criaPerfil(){
		return "criar-perfil";
	}
}
