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
import br.com.prosperity.util.EncriptaDecriptaApacheCodec;

@Component
public class UsuarioBusiness {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private UsuarioConverter usuarioConverter;

	@Transactional
	public void inserir(UsuarioBean usuarioBean) {
		if(usuarioBean.getNome().isEmpty()) {
			System.out.println("erro");
		}
		
		boolean existeUsuario = !usuarioDAO.findByNamedQuery("existeUsuario", usuarioBean.getNome()).isEmpty();
		
		if(existeUsuario) {
			throw new RuntimeException("Usuário já existe");
		}
		
		EncriptaDecriptaApacheCodec codec = new EncriptaDecriptaApacheCodec();
		
		usuarioBean.setSenha(codec.codificaBase64Encoder(usuarioBean.getSenha()));
		
		UsuarioEntity entity = usuarioConverter.convertBeanToEntity(usuarioBean);
		usuarioDAO.adicionar(entity);
	}

	public UsuarioBean autenticar(UsuarioBean usuarioBean) throws BusinessException {
		List<UsuarioEntity> usuarios = usuarioDAO.findByNamedQuery("obterPorUsuario", usuarioBean.getNome());

		EncriptaDecriptaApacheCodec codec = new EncriptaDecriptaApacheCodec();
		usuarioBean.setSenha(codec.codificaBase64Encoder(usuarioBean.getSenha()));
		
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

	public UsuarioBean consultar(UsuarioBean usuarioBean) throws BusinessException {
		List<UsuarioEntity> usuarios = usuarioDAO.findByNamedQuery("obterPorUsuario", usuarioBean.getNome());

		if (usuarios != null) {
			for (UsuarioEntity usuarioEntity : usuarios) {
				usuarioBean = usuarioConverter.convertEntityToBean(usuarioEntity);
			}
		}

		if (!usuarioBean.getAutenticado()) {
			throw new BusinessException("Erro a alterar senha: ");
		}
		return usuarioBean;
	}

	@Transactional
	public void alterar(UsuarioBean usuarioBean) {
		EncriptaDecriptaApacheCodec codec = new EncriptaDecriptaApacheCodec();
		usuarioBean.setSenha(codec.codificaBase64Encoder(usuarioBean.getSenha()));
		
		usuarioBean.setPrimeiroAcesso(false);
		
		usuarioDAO.alterar(usuarioConverter.convertBeanToEntity(usuarioBean));
	}

	@Transactional(readOnly=true)
	public List<UsuarioBean> listar() {
		List<UsuarioBean> usuarios = usuarioConverter.convertEntityToBean(usuarioDAO.listar());
		return usuarios;
	}
	
	@Transactional(readOnly=true)
	public List<UsuarioBean> buscarGestor(){
		List<UsuarioEntity> usuariosEntity = usuarioDAO.findByNamedQuery("obterGestor");
		List<UsuarioBean> usuariosBean = usuarioConverter.convertEntityToBean(usuariosEntity);
		return usuariosBean;
	}

	@Transactional(readOnly=true)
	public UsuarioBean obterPorId(Integer id) {
		UsuarioBean bean = usuarioConverter.convertEntityToBean(usuarioDAO.obterPorId(id));
		return bean;
	}

	@Transactional
	public void mudarStatus(Integer id) {
		UsuarioBean usuario = this.obterPorId(id);
		usuario.setAtivo(!usuario.getAtivo());
		usuarioDAO.alterar(usuarioConverter.convertBeanToEntity(usuario));
	}

	@Transactional
	public void redefinirSenha(Integer id) {
		UsuarioBean usuario = this.obterPorId(id);
		EncriptaDecriptaApacheCodec codec = new EncriptaDecriptaApacheCodec();
		usuario.setSenha(codec.codificaBase64Encoder(usuario.getSENHA_PADRAO()));
		usuario.setPrimeiroAcesso(true);
		usuarioDAO.alterar(usuarioConverter.convertBeanToEntity(usuario));
	}

}
