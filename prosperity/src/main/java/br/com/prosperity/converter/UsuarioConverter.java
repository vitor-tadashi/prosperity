package br.com.prosperity.converter;


import java.util.List;

import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.entity.UsuarioEntity;

public class UsuarioConverter implements Converter<UsuarioEntity,UsuarioBean>{

	@Override
	public UsuarioEntity convertBeanToEntity(UsuarioBean bean) {
		UsuarioEntity entity = new UsuarioEntity();
		
		entity.setId(bean.getIdUsuario());
		entity.setNome(bean.getnome());
		entity.setSenha(bean.getSenha());
		return entity;
	}

	@Override
	public UsuarioBean convertEntityToBean(UsuarioEntity entity) {
		UsuarioBean bean = new UsuarioBean();
		
		bean.setIdUsuario(entity.getId());
		bean.setUsuario(entity.getNome());
		bean.setSenha(entity.getSenha());
		return bean;
	}

	@Override
	public List<UsuarioBean> convertEntityToBean(List<UsuarioEntity> entities) {
		// TODO Auto-generated method stub
		return null;
	}
}
