package br.com.prosperity.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.converter.UsuarioConverter;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.entity.UsuarioEntity;

@Component
public class UsuarioBusiness {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private UsuarioConverter usuarioConverter;
	
	private UsuarioEntity usuarioEntity;

	public void inserir(UsuarioBean usuarioBean) {
		usuarioDAO.adicionar(usuarioConverter.convertBeanToEntity(usuarioBean));
	}

	public UsuarioBean logar(UsuarioBean usuarioBean) {
		try {
			usuarioEntity = usuarioDAO.obterPorUsuario(usuarioConverter.convertBeanToEntity(usuarioBean));
			if (usuarioEntity != null) {
				return usuarioBean;
			} else {
				 return null;
			}
		} catch (Exception e) {
			throw (e);
		}
	}
}
