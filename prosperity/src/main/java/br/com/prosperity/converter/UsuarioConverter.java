package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.entity.UsuarioEntity;

@Component
public class UsuarioConverter implements Converter<UsuarioEntity, UsuarioBean> {

	@Autowired
	private PerfilConverter perfilConverter;

	@Override
	public UsuarioEntity convertBeanToEntity(UsuarioBean bean) {
		if (bean == null) {
			return null;
		}
		UsuarioEntity entity = new UsuarioEntity();

		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setSenha(bean.getSenha());
		entity.setNmFuncionario(bean.getNomeFuncionario());;
		entity.setPerfilEntity(perfilConverter.convertBeanToEntity(bean.getPerfil()));
		entity.setPrimeiroAcesso(bean.getPrimeiroAcesso());
		entity.setAtivo(bean.getAtivo());
		entity.setEmail(bean.getEmail());

		return entity;
	}

	@Override
	public UsuarioBean convertEntityToBean(UsuarioEntity entity) {
		if (entity == null) {
			return null;
		}
		UsuarioBean bean = new UsuarioBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setSenha(entity.getSenha());
		bean.setNomeFuncionario(entity.getNmFuncionario());
		bean.setPerfil(perfilConverter.convertEntityToBean(entity.getPerfilEntity()));
		bean.setPrimeiroAcesso(entity.getPrimeiroAcesso());
		bean.setAtivo(entity.getAtivo());
		bean.setEmail(entity.getEmail());

		return bean;
	}
}