package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.SituacaoAtualBean;
import br.com.prosperity.entity.SituacaoAtualEntity;

public class SituacaoAtualConverter implements Converter<SituacaoAtualEntity, SituacaoAtualBean> {

	@Override
	public SituacaoAtualEntity convertBeanToEntity(SituacaoAtualBean bean) {
		SituacaoAtualEntity entity = new SituacaoAtualEntity();
		entity.setIdSituacaoAtual(bean.getId());
		return entity;
	}

	@Override
	public SituacaoAtualBean convertEntityToBean(SituacaoAtualEntity entity) {
		SituacaoAtualBean bean = new SituacaoAtualBean();
		bean.setIdSituacaoAtual(entity.getIdSituacaoAtual());
		return bean;
	}

	@Override
	public List<SituacaoAtualBean> convertEntityToBean(List<SituacaoAtualEntity> entities) {
		List<SituacaoAtualBean>  beanList = new ArrayList<>();
		for(SituacaoAtualEntity e: entities){
			beanList.add(convertEntityToBean(e));
			
		}
		
		return beanList;
	}

}
