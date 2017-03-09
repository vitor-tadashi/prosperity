package br.com.prosperity.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.converter.UsuarioConverter;
import br.com.prosperity.dao.UsuarioDAO;

@Component
public class UsuarioBusiness {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private UsuarioConverter usuarioConverter;

	public void inserir(UsuarioBean usuarioBean) {
		usuarioDAO.adicionar(usuarioConverter.convertBeanToEntity(usuarioBean));
	}
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
