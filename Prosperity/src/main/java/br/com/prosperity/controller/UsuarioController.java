package br.com.prosperity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		List<FuncionarioBean> funcionarios = funcionarioBusiness.obterTodos();
		List<PerfilBean> perfis = perfilBusiness.listar();
		model.addAttribute("funcionarios", funcionarios);
		model.addAttribute("perfis", perfis);
		model.addAttribute("usuarios", usuarios);

		return "usuario/consultar-usuario";
	}

	@RequestMapping(value = {"/carregar-usuario"}, method = RequestMethod.GET)
	public @ResponseBody UsuarioBean carregaUsuarioAjax(Model model, @ModelAttribute("id") Integer id) {
		UsuarioBean usuario = usuarioBusiness.obterPorId(id);
		return usuario;
	}
	
	@RequestMapping(value = {"/carregar-combos"}, method = RequestMethod.GET)
	public @ResponseBody List<Object> carregaCombosAjax(Model model) {
		List<Object> lista = new ArrayList<>();
		List<FuncionarioBean> funcionarios = funcionarioBusiness.obterTodos();
		List<PerfilBean> perfis = perfilBusiness.listar();
		
		lista.add(perfis);
		lista.add(funcionarios);
		
		return lista;
	}

	@RequestMapping(value = "/criar-perfil", method = RequestMethod.GET)
	public String criaPerfil(Model model, String erros) {
		List<FuncionalidadeBean> funcionalidades = funcionalidadeBusiness.listar();
		List<PerfilBean> perfis = perfilBusiness.listar();
		model.addAttribute("funcionalidades", funcionalidades);
		model.addAttribute("perfis", perfis);
		model.addAttribute("erros",erros);
		
		return "usuario/criar-perfil";
	}

	@RequestMapping(value = "/salvar-perfil", method = RequestMethod.POST)
	public String inserirPerfil(@ModelAttribute("perfilBean") PerfilBean perfilBean, Model model) throws BusinessException {
		try{
			perfilBusiness.inserir(perfilBean);
		}catch(BusinessException e){
			model.addAttribute("erros", e.getMessage());
		}

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
	
	@RequestMapping(value = "/mudar-status", method = RequestMethod.POST)
	public void mudarStatusAjax(Integer id, HttpServletResponse response) {
		usuarioBusiness.mudarStatus(id);
	}
	
	@RequestMapping(value = "/redefinir-senha", method = RequestMethod.POST)
	public void redefinirSenhaAjax(Integer id, HttpServletResponse response) {
		usuarioBusiness.redefinirSenha(id);
	}
	
	@RequestMapping(value = "obter-perfil-funcionalidade", method=RequestMethod.GET)
	public @ResponseBody List<FuncionalidadeBean> obterPerfilFuncionalidade(Model model,@ModelAttribute("id")Integer id){
		List<FuncionalidadeBean> listaFunc = perfilBusiness.obterPerfilFuncionalidades(id);
		return listaFunc;
	}

}
