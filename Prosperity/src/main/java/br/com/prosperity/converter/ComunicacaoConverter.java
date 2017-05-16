package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.prosperity.bean.ComunicacaoBean;
import br.com.prosperity.entity.ComunicacaoEntity;

public class ComunicacaoConverter implements Converter<ComunicacaoEntity, ComunicacaoBean>{

	@Autowired
	private CandidatoConverter candidatoConverter;
	

	@Autowired
	private UsuarioConverter usuarioConverter;
	
	@Override
	public ComunicacaoEntity convertBeanToEntity(ComunicacaoBean bean) {
		if (bean == null) {
			return null;
		}
		
		ComunicacaoEntity entity = new ComunicacaoEntity();
		
		entity.setCandidatoEntity(candidatoConverter.convertBeanToEntity(bean.getCandidatoBean()));
		entity.setDataContato(bean.getDataContato());
		entity.setId(bean.getId());
		entity.setObservacao(bean.getObservacao());
		entity.setUsuarioEntity(usuarioConverter.convertBeanToEntity(bean.getUsuarioBean()));
		
		return entity;
	}

	@Override
	public ComunicacaoBean convertEntityToBean(ComunicacaoEntity entity) {
		if (entity == null) {
			return null;
		}
		
		ComunicacaoBean bean = new ComunicacaoBean();
		
		bean.setCandidatoBean(candidatoConverter.convertEntityToBean(entity.getCandidatoEntity()));
		bean.setDataContato(bean.getDataContato());
		bean.setId(bean.getId());
		bean.setObservacao(bean.getObservacao());
		bean.setUsuarioBean(usuarioConverter.convertEntityToBean(entity.getUsuarioEntity()));
		
		return bean;
	}

}
