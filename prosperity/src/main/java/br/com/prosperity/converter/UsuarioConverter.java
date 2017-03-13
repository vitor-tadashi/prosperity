package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.entity.UsuarioEntity;

@Component
public class UsuarioConverter implements Converter<UsuarioEntity,UsuarioBean>{

	@Autowired
	private FuncionarioConverter funcionarioConverter;
	
	@Autowired
	private PerfilConverter perfilConverter;
	
	@Override
	public UsuarioEntity convertBeanToEntity(UsuarioBean bean) {
		UsuarioEntity entity = new UsuarioEntity();
		
		try {
			entity.setId(bean.getId());
			entity.setNome(bean.getNome());
			entity.setSenha(bean.getSenha());
			entity.setFuncionarioEntity(funcionarioConverter.convertBeanToEntity(bean.getFuncionario()));
			entity.setPerfilEntity(perfilConverter.convertBeanToEntity(bean.getPerfil()));
			entity.setPrimeiroAcesso(bean.getPrimeiroAcesso());
			entity.setEmail(bean.getEmail());
		} catch (Exception e) {
			throw new RuntimeException("ERRO NO CONVERTER :" + e);
		}
		
		return entity;
	}

	@Override
	public UsuarioBean convertEntityToBean(UsuarioEntity entity) {
		UsuarioBean bean = new UsuarioBean();
		
		try {
			bean.setId(entity.getId());
			bean.setNome(entity.getNome());
			bean.setSenha(entity.getSenha());
			bean.setFuncionario(funcionarioConverter.convertEntityToBean(entity.getFuncionarioEntity()));
			bean.setPerfil(perfilConverter.convertEntityToBean(entity.getPerfilEntity()));
			bean.setPrimeiroAcesso(entity.getPrimeiroAcesso());
			bean.setEmail(entity.getEmail());
		} catch (Exception e) {
			throw new RuntimeException("ERRO NO CONVERTER :" + e);
		}
		
		return bean;
	}
}
