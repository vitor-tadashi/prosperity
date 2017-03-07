package br.com.prosperity.converter;

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

}
