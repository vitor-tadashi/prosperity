package br.com.prosperity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.business.FuncionalidadeBusiness;
import br.com.prosperity.business.UsuarioBusiness;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private FuncionalidadeBusiness funcionalidadeBusiness;
	
	@Autowired
	private UsuarioBusiness usuarioBusiness;
	
	@RequestMapping(value ="/consultar", method = RequestMethod.GET)
	public String consultaUsuario(){
		return "usuario/consultar-usuario";
	}
	@RequestMapping(value ="/criar-perfil", method = RequestMethod.GET)
	public String criaPerfil(Model model){
		List<FuncionalidadeBean> funcionalidades = funcionalidadeBusiness.obterTodos(); 
		model.addAttribute("funcionalidades",funcionalidades);
		
		return "usuario/criar-perfil";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String inserirUsuario(UsuarioBean usuarioBean) {
		usuarioBusiness.inserir(usuarioBean);
		return "usuario/consultar-usuario";
	}
}
