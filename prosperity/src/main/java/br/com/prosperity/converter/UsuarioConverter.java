package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.UsuarioBean;
import br.com.prosperity.entity.UsuarioEntity;
import br.com.prosperity.util.EncriptaDecriptaApacheCodec;

@Component
public class UsuarioConverter implements Converter<UsuarioEntity,UsuarioBean>{

	@Autowired
	private FuncionarioConverter funcionarioConverter;
	
	@Autowired
	private PerfilConverter perfilConverter;
	
	@Override
	public UsuarioEntity convertBeanToEntity(UsuarioBean bean) {
		UsuarioEntity entity = new UsuarioEntity();
		
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		entity.setSenha(new EncriptaDecriptaApacheCodec().codificaBase64Encoder(bean.getSenha()));
		entity.setFuncionarioEntity(funcionarioConverter.convertBeanToEntity(bean.getFuncionario()));
		entity.setPerfilEntity(perfilConverter.convertBeanToEntity(bean.getPerfil()));
		entity.setPrimeiroAcesso(bean.getPrimeiroAcesso());
		entity.setAtivo(bean.getAtivo());
		entity.setEmail(bean.getEmail());
		
		return entity;
	}

	@Override
	public UsuarioBean convertEntityToBean(UsuarioEntity entity) {
		UsuarioBean bean = new UsuarioBean();
		
		bean.setId(entity.getId());
		bean.setNome(entity.getNome());
		bean.setSenha(new EncriptaDecriptaApacheCodec().codificaBase64Encoder(entity.getSenha()));
		bean.setFuncionario(funcionarioConverter.convertEntityToBean(entity.getFuncionarioEntity()));
		bean.setPerfil(perfilConverter.convertEntityToBean(entity.getPerfilEntity()));
		bean.setPrimeiroAcesso(entity.getPrimeiroAcesso());
		bean.setAtivo(entity.getAtivo());
		bean.setEmail(entity.getEmail());
		
		return bean;
	}
}
