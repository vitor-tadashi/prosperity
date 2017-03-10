package br.com.prosperity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.bean.PerfilBean;
import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.business.FuncionalidadeBusiness;
import br.com.prosperity.business.FuncionarioBusiness;
import br.com.prosperity.business.PerfilBusiness;
import br.com.prosperity.business.UsuarioBusiness;

@Controller
@RequestMapping("usuario")
public class UsuarioController{
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
		List<FuncionarioBean> funcionarios = funcionarioBusiness.getFuncionarios();
		model.addAttribute("funcionarios", funcionarios);
		
		return "usuario/consultar-usuario";
	}

	@RequestMapping(value = "/criar-perfil", method = RequestMethod.GET)
	public String criaPerfil(Model model) {
		List<FuncionalidadeBean> funcionalidades = funcionalidadeBusiness.obterTodos();
		model.addAttribute("funcionalidades", funcionalidades);

		return "usuario/criar-perfil";
	}

	@RequestMapping(value = "/salvar-perfil", method = RequestMethod.POST)
	public String salvarPerfil(@ModelAttribute("perfilBean") PerfilBean perfilBean, Model model, ModelAndView modelAndView) {
		try {
			if (perfilBean.getListaFuncionalidades().isEmpty()) {
				System.out.println("erro   " + perfilBean.getNome());
			} else {
				System.out.println(perfilBean.getListaFuncionalidades().get(1).getId());
			}
		} catch (Exception e) {
			System.out.println("Exception! " + e.getLocalizedMessage() + perfilBean.getNome());
		}

		perfilBusiness.inserir(perfilBean);
		System.out.println(perfilBean.getNome());

		return "redirect:criar-perfil";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String inserirUsuario(UsuarioBean usuarioBean) {
		usuarioBusiness.inserir(usuarioBean);
		return "usuario/consultar-usuario";
	}
}
