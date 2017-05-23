package br.com.prosperity.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.business.UsuarioBusiness;
import br.com.prosperity.exception.BusinessException;

@Controller
@RequestMapping(value = "login")
public class LoginController {

	@Autowired
	private UsuarioBusiness usuarioBusiness;

	@Autowired
	private UsuarioBean usuario;

	@Autowired
	private HttpSession session;

	@RequestMapping(method = RequestMethod.GET)
	public String indexLogin() {
		return "login/acesso";
	}

	@RequestMapping(value = "/autenticar", method = RequestMethod.POST)
	public String autenticar(UsuarioBean usuarioBean, Model model) {
		try {
			usuario = usuarioBusiness.autenticar(usuarioBean);
			if (usuario.getPrimeiroAcesso()) {
				session.setAttribute("autenticado", usuario);
				return "login/primeiro-acesso";
			} else {
				session.setAttribute("autenticado", usuario);
				return "redirect:/pagina-inicial";
			}
		} catch (BusinessException ex) {
			model.addAttribute("log", ex.getMessage());
		}
		return "login/acesso";
	}

	@RequestMapping(value = "/primeiro-acesso", method = RequestMethod.GET)
	public String primeiroAcessoUsuario() throws BusinessException {
		return "login/acesso";
	}

	@RequestMapping(value = "/primeiro-acesso", method = RequestMethod.POST)
	public String primeiroAcessoUsuario(UsuarioBean usuarioBean) throws BusinessException {
		usuario.setSenha(usuarioBean.getSenha());
		usuarioBusiness.alterar(usuario);
		return "redirect:/pagina-inicial";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/acesso";
	}
}