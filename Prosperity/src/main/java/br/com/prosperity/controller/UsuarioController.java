package br.com.prosperity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.bean.PerfilBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.business.FuncionalidadeBusiness;
import br.com.prosperity.business.FuncionarioBusiness;
import br.com.prosperity.business.PerfilBusiness;
import br.com.prosperity.business.UsuarioBusiness;
import br.com.prosperity.entity.PerfilEntity;
import br.com.prosperity.exception.BusinessException;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private FuncionalidadeBusiness funcionalidadeBusiness;

	@Autowired
	private PerfilBusiness perfilBusiness;

	@Autowired
	private FuncionarioBusiness funcionarioBusiness;

	@Autowired
	private UsuarioBusiness usuarioBusiness;

	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public String consultaUsuario(Model model) {
		List<UsuarioBean> usuarios = usuarioBusiness.getUsuarios();
		List<FuncionarioBean> funcionarios = funcionarioBusiness.getFuncionarios();
		List<PerfilEntity> perfis = perfilBusiness.getPerfis();
		model.addAttribute("funcionarios", funcionarios);
		model.addAttribute("perfis", perfis);
		model.addAttribute("usuarios", usuarios);
		
		return "usuario/consultar-usuario";
	}

	@RequestMapping(value = "/criar-perfil", method = RequestMethod.GET)
	public String criaPerfil(Model model) {
		List<FuncionalidadeBean> funcionalidades = funcionalidadeBusiness.obterTodos();
		List<PerfilBean> perfis = perfilBusiness.obterTodos();
		model.addAttribute("funcionalidades", funcionalidades);
		model.addAttribute("perfis", perfis);

		return "usuario/criar-perfil";
	}

	@RequestMapping(value = "/salvar-perfil", method = RequestMethod.POST)
	public String salvarPerfil(@ModelAttribute("perfilBean") PerfilBean perfilBean) throws BusinessException {
		perfilBusiness.inserir(perfilBean);

		return "redirect:criar-perfil";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String inserirUsuario(@ModelAttribute("usuario") UsuarioBean usuario) {
		usuarioBusiness.inserir(usuario);
		return "redirect:consultar";
	}
}
