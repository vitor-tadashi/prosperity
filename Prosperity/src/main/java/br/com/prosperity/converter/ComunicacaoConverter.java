package br.com.prosperity.converter;

import br.com.prosperity.bean.ComunicacaoBean;
import br.com.prosperity.entity.ComunicacaoEntity;

public class ComunicacaoConverter implements Converter<ComunicacaoEntity, ComunicacaoBean>{

	@Override
	public ComunicacaoEntity convertBeanToEntity(ComunicacaoBean bean) {
		if (bean == null) {
			return null;
		}
		
		ComunicacaoEntity entity = new ComunicacaoEntity();
		
		//entity.setCandidato(bean.getCandidato());
		//entity.setDataContato(bean.getDataContato());
		//entity.setId(bean.getId());
		//entity.setObservacao(bean.getObservacao());
		//entity.setUsuario(bean.getUsuario());
		
		return entity;
	}

	@Override
	public ComunicacaoBean convertEntityToBean(ComunicacaoEntity entity) {
		if (entity == null) {
			return null;
		}
		
		ComunicacaoBean bean = new ComunicacaoBean();
		
		//bean.setCandidato(entity.getCandidato());
		//bean.setDataContato(entity.getDataContato());
		//bean.setId(entity.getId());
		//bean.setObservacao(entity.getObservacao());
		//bean.setUsuario(entity.getUsuario());
		
		return bean;
	}

}
