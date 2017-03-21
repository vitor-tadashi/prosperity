package br.com.prosperity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String carregaTabela(Model model) {
		List<UsuarioBean> usuarios = usuarioBusiness.listar();
		List<FuncionarioBean> funcionarios = funcionarioBusiness.listarApenasNaoCadastrados();
		List<PerfilBean> perfis = perfilBusiness.obterTodos();
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
	public String inserirUsuario(UsuarioBean usuario) {
		if (usuario.getId() == null) {
			usuarioBusiness.inserir(usuario);
		} else {
			usuarioBusiness.alterar(usuario);
		}

		return "redirect:listar";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String redirecionaLista(UsuarioBean usuario) {
		return "redirect:listar";
	}
	
	@RequestMapping(value = {"/carregar-usuario-api"}, method = RequestMethod.GET)
	public @ResponseBody UsuarioBean carregaUsuarioAjax(Integer id) {
		UsuarioBean usuario = usuarioBusiness.obterPorId(id);
		return usuario;
	}
	
	@RequestMapping(value = "/mudar-status-api", method = RequestMethod.POST)
	public void mudarStatusAjax(Integer id) {
		usuarioBusiness.mudarStatus(id);
	}
	
	@RequestMapping(value = "/redefinir-senha-api", method = RequestMethod.POST)
	public void redefinirSenhaAjax(Integer id) {
		usuarioBusiness.redefinirSenha(id);
	}
	
	@RequestMapping(value = "obter-perfil-funcionalidade", method=RequestMethod.GET)
	public @ResponseBody List<FuncionalidadeBean> obterPerfilFuncionalidade(Model model,@ModelAttribute("id")Integer id){
		List<FuncionalidadeBean> listaFunc = perfilBusiness.obterFuncionalidades(id);
		return listaFunc;
	}

}
