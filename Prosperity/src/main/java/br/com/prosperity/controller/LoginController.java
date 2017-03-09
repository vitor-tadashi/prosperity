package br.com.prosperity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.business.UsuarioBusiness;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioBusiness usuarioBusiness;
	
	@Autowired
	private UsuarioBean usuario;
	
	@RequestMapping(value ="login", method = RequestMethod.GET)
	public String indexLogin() {
		return "login/acesso";
	}

	@RequestMapping(value ="login", method = RequestMethod.POST)
	public String Logar(UsuarioBean usuarioBean) {
		usuario = usuarioBusiness.logar(usuarioBean);
		if (usuario!=null){
		return "login/primeiro-acesso";
		}
		else{
			return "login/acesso";
		}
	}
	
	@RequestMapping(value ="primeiro-acesso", method = RequestMethod.GET)
	public String primeiroAcessoUsuario(){
		return "login/primeiro-acesso";
	}
}
