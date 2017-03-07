package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.ContatoBean;
import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.entity.ContatoEntity;
import br.com.prosperity.entity.FuncionalidadeEntity;

public class ContatoConverter implements Converter<ContatoEntity, ContatoBean> {

	@Override
	public ContatoEntity convertBeanToEntity(ContatoBean bean) {
		ContatoEntity entity = new ContatoEntity();
		entity.setId(bean.getId());
		entity.setCandidato(new CandidatoConverter().convertBeanToEntity(bean.getCandidato()));
		entity.setCelular(bean.getCelular());
		entity.setTelefone(bean.getTelefone());
		return entity;
	}

	@Override
	public ContatoBean convertEntityToBean(ContatoEntity entity) {
		ContatoBean bean = new ContatoBean();
		bean.setId(entity.getId());
		bean.setCandidato(new CandidatoConverter().convertEntityToBean(entity.getCandidato()));
		bean.setCelular(entity.getCelular());
		bean.setTelefone(entity.getTelefone());
		return null;
	}

	@Override
	public List<ContatoBean> convertEntityToBean(List<ContatoEntity> entities) {
		List<ContatoBean> beanList = new ArrayList<>();
		
		for (ContatoEntity e : entities) {
			beanList.add(convertEntityToBean(e));
		}

		return beanList;
	}
}
