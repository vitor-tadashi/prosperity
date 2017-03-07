package br.com.prosperity.converter;


import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.entity.UsuarioEntity;

public class UsuarioConverter implements Converter<UsuarioEntity,UsuarioBean>{

	@Override
	public UsuarioEntity convertBeanToEntity(UsuarioBean bean) {
		UsuarioEntity entity = new UsuarioEntity();
		
		entity.setId(bean.getIdUsuario());
		return entity;
	}

	@Override
	public UsuarioBean convertEntityToBean(UsuarioEntity entity) {
		UsuarioBean bean = new UsuarioBean();
		
		bean.setIdUsuario(entity.getId());
		return bean;
	}

	

}
