package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.converter.UsuarioConverter;
import br.com.prosperity.dao.UsuarioDAO;
import br.com.prosperity.entity.UsuarioEntity;
import br.com.prosperity.exception.BusinessException;

@Component
public class UsuarioBusiness {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private UsuarioConverter usuarioConverter;

	public void inserir(UsuarioBean usuarioBean) {
		usuarioDAO.adicionar(usuarioConverter.convertBeanToEntity(usuarioBean));
	}

	public UsuarioBean autenticar(UsuarioBean usuarioBean) throws BusinessException {

		List<UsuarioEntity> usuarios = usuarioDAO.findByNamedQuery("obterPorUsuario", usuarioBean.getNome());

		if (usuarios != null) {
			for (UsuarioEntity usuarioEntity : usuarios) {
				if (usuarioBean.getSenha().equals(usuarioEntity.getSenha())) {
					usuarioBean = usuarioConverter.convertEntityToBean(usuarioEntity);
					usuarioBean.setAutenticado(true);
				}
			}
		}

		if (!usuarioBean.getAutenticado()) {
			throw new BusinessException("Usuário ou senha inválidos");
		}

		return usuarioBean;
	}

	public void alterar(UsuarioBean usuarioBean) {
		UsuarioEntity usuarioEntity = usuarioDAO.alterar(usuarioConverter.convertBeanToEntity(usuarioBean));
	}

}
