package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.FormacaoBean;
import br.com.prosperity.entity.FormacaoEntity;

@Component
public class FormacaoConverter implements Converter<FormacaoEntity, FormacaoBean> {
	
	@Autowired
	SituacaoAtualConverter SituacaoAtual;
	@Autowired
	TipoCursoConverter tipoCurso;

	@Override
	public FormacaoEntity convertBeanToEntity(FormacaoBean bean) {
		if (bean == null) {
			return null;
		}
		FormacaoEntity entity = new FormacaoEntity();
		entity.setId(bean.getId());
		entity.setNome(bean.getNomeInstituicao());
		entity.setNomeCurso(bean.getNomeCurso());
		entity.setDataConclusao(bean.getDataConclusao());
		entity.setTipoCurso(tipoCurso.convertBeanToEntity(bean.getTipoCurso()));
		entity.setSituacaoAtual(SituacaoAtual.convertBeanToEntity(bean.getSituacaoAtual()));
		return entity;
	}

	@Override
	public FormacaoBean convertEntityToBean(FormacaoEntity entity) {
		if (entity == null) {
			return null;
		}
		FormacaoBean bean = new FormacaoBean();
		bean.setId(entity.getId());
		bean.setNomeInstituicao(entity.getNome());
		bean.setNomeCurso(entity.getNomeCurso());
		bean.setDataConclusao(entity.getDataConclusao());
		bean.setSituacaoAtual(SituacaoAtual.convertEntityToBean(entity.getSituacaoAtual()));
		bean.setTipoCurso(tipoCurso.convertEntityToBean(entity.getTipoCurso()));
		return bean;
	}
}
