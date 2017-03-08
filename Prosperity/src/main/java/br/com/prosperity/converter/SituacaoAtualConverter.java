package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.SituacaoAtualBean;
import br.com.prosperity.entity.SituacaoAtualEntity;

@Component
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
