package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public void inserir(UsuarioBean usuarioBean) {
		UsuarioEntity entity = usuarioConverter.convertBeanToEntity(usuarioBean);
		usuarioDAO.adicionar(entity);
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
	
	@Transactional
	public void alterar(UsuarioBean usuarioBean) {
		UsuarioEntity usuarioEntity = usuarioDAO.alterar(usuarioConverter.convertBeanToEntity(usuarioBean));
	}
	
	@Transactional
	public List<UsuarioBean> getUsuarios() {
		List<UsuarioBean> usuarios = usuarioConverter.convertEntityToBean(usuarioDAO.findByNamedQuery("populaTabela", UsuarioEntity.class));
		
		return usuarios;
	}
}
