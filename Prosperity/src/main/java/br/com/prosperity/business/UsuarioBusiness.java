package br.com.prosperity.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.entity.UsuarioEntity;

@Controller
public class UsuarioBusiness {
	/*
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private UsuarioBean usuarioBean;

	@Autowired
	private UsuarioEntity usuarioEntity;

	public UsuarioBean logar(String login, String senha) {
		try {
			UsuarioBean usuarioIgual = usuarioDAO.obterPorUsuario(login, senha);
			if (usuarioIgual != null) {
				return usuarioIgual;
			} else {
				 return null;
			}
		} catch (Exception e) {
			throw (e);
		}
	}
	*/
}
