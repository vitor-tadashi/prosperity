package br.com.prosperity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	@RequestMapping(value ="/consultar", method = RequestMethod.GET)
	public String consultaUsuario(){
		return "consultar-usuario";
	}
	@RequestMapping(value ="/criar-perfil", method = RequestMethod.GET)
	public String criaPerfil(){
		return "criar-perfil";
	}
}
