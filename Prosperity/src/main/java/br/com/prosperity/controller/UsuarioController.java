package br.com.prosperity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping(value = "/gerenciar", method = RequestMethod.GET)
	public String carregaUsuarios(Model model) {
		List<UsuarioBean> usuarios = usuarioBusiness.findAll();
		List<FuncionarioBean> funcionarios = funcionarioBusiness.findAll();
		List<PerfilBean> perfis = perfilBusiness.listar();
		model.addAttribute("funcionarios", funcionarios);
		model.addAttribute("perfis", perfis);
		model.addAttribute("usuarios", usuarios);
		
		return "usuario/gerenciar-usuario";
	}

	@RequestMapping(value = "/perfil/gerenciar", method = RequestMethod.GET)
	public String criaPerfil(Model model) {
		List<FuncionalidadeBean> funcionalidades = funcionalidadeBusiness.listar();
		List<PerfilBean> perfis = perfilBusiness.listar();
		model.addAttribute("funcionalidades", funcionalidades);
		model.addAttribute("perfis", perfis);
		
		return "usuario/gerenciar-perfil";
	}

	@RequestMapping(value = "/perfil/salvar-perfil", method = RequestMethod.POST)
	public String inserirPerfil(@ModelAttribute("perfilBean") PerfilBean perfilBean, RedirectAttributes redirectAttributes ) throws BusinessException {
		try{
			perfilBusiness.inserir(perfilBean);
			redirectAttributes.addFlashAttribute("sucesso", "Perfil salvo com sucesso.");
			
		}catch(BusinessException e){
			redirectAttributes.addFlashAttribute("erros", e.getMessage());
		}

		return "redirect:gerenciar";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String inserirUsuario(UsuarioBean usuario, RedirectAttributes redirectAttrs) {
		try {
			usuarioBusiness.inserir(usuario);
		} catch (BusinessException e) {
			redirectAttrs.addFlashAttribute("erro", e.getMessage());
		}
		
		return "redirect:gerenciar";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String redirecionaLista() {
		return "redirect:gerenciar";
	}
	
	@RequestMapping(value = {"/carregar-usuario-api/{id}"}, method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody UsuarioBean carregaUsuarioAjax(@PathVariable Integer id) {
		UsuarioBean usuario = usuarioBusiness.obterPorId(id);
		return usuario;
	}
	
	@RequestMapping(value = "/mudar-status-api/{id}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void mudarStatusAjax(@PathVariable Integer id) {
		usuarioBusiness.mudarStatus(id);
	}
	
	@RequestMapping(value = "/redefinir-senha-api/{id}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void redefinirSenhaAjax(@PathVariable Integer id) {
		usuarioBusiness.redefinirSenha(id);
	}
	
	@RequestMapping(value = "obter-perfil-funcionalidade", method=RequestMethod.GET)
	public @ResponseBody List<FuncionalidadeBean> obterPerfilFuncionalidade(Model model,@ModelAttribute("id")Integer id){
		List<FuncionalidadeBean> listaFunc = perfilBusiness.obterPerfilFuncionalidades(id);
		return listaFunc;
	}

}
