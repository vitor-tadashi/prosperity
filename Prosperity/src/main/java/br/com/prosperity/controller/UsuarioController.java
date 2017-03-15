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
	
	@Autowired
	private UsuarioBean usuario;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String carregaTabela(Model model) {
		List<UsuarioBean> usuarios = usuarioBusiness.obterTodos();
		model.addAttribute("usuarios", usuarios);

		return "usuario/consultar-usuario";
	}

	@RequestMapping(value = {"/inserir-usuario", "/alterar-usuario"}, method = RequestMethod.GET)
	public String carregaCombos(Integer id, Model model) {
		List<FuncionarioBean> funcionarios = funcionarioBusiness.obterTodos();
		List<PerfilBean> perfis = perfilBusiness.obterTodos();
		model.addAttribute("funcionarios", funcionarios);
		model.addAttribute("perfis", perfis);
		
		if (id != null) {
			model.addAttribute("title", "Alterar");
			
			usuario = usuarioBusiness.obterUsuarioPorId(id);
			model.addAttribute("usuario", usuario);
		} else {
			model.addAttribute("title", "Inserir");
		}
		
		return "usuario/formulario";
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
	public String inserirUsuario(UsuarioBean usuario) {
		if (usuario.getId() == null) {
			usuarioBusiness.inserir(usuario);
		} else {
			usuarioBusiness.alterar(usuario);
		}

		return "redirect:listar";
	}
	
	@RequestMapping(value = "/mudar-status", method = RequestMethod.GET)
	public String mudarStatus(Boolean ativo) {
		usuario.setAtivo(!ativo);
		usuarioBusiness.alterar(usuario);

		return "redirect:alterar-usuario?id=" + usuario.getId();
	}

}
