package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.FormacaoBean;
import br.com.prosperity.bean.SituacaoAtualBean;
import br.com.prosperity.bean.TipoCursoBean;
import br.com.prosperity.dao.TipoCursoDAO;
import br.com.prosperity.entity.FormacaoEntity;

@Component
public class FormacaoConverter implements Converter<FormacaoEntity, FormacaoBean> {
	@Autowired
	SituacaoAtualConverter SituacaoAtual;
	@Autowired
	TipoCursoConverter tipoCurso;

	@Override
	public FormacaoEntity convertBeanToEntity(FormacaoBean bean) {
		FormacaoEntity entity = new FormacaoEntity();
		entity.setId(bean.getId());
		entity.setNome(bean.getNomeInstituicao());
		entity.setDataConclusao(bean.getDataConclusao());
		entity.setSituacaoAtualEntity(SituacaoAtual.convertBeanToEntity(bean.getSituacaoAtualBean()));
		entity.setTipoCursoEntity(tipoCurso.convertBeanToEntity(bean.getTipoCursoBean()));
	
 
		return entity;
	}

	@Override
	public FormacaoBean convertEntityToBean(FormacaoEntity entity) {
		FormacaoBean bean = new FormacaoBean();
		bean.setId(entity.getId());
		bean.setNomeInstituicao(entity.getNome());
		bean.setDataConclusao(entity.getDataConclusao());
		bean.setSituacaoAtualBean(SituacaoAtual.convertEntityToBean(entity.getSituacaoAtualEntity()));
		bean.setTipoCursoBean(tipoCurso.convertEntityToBean(entity.getTipoCursoEntity()));
		return bean;
	}
}
