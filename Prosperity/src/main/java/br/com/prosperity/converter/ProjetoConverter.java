package br.com.prosperity.converter;

import java.util.List;

import br.com.prosperity.bean.ProjetoBean;
import br.com.prosperity.entity.ProjetoEntity;

public class ProjetoConverter implements Converter<ProjetoEntity, ProjetoBean> {

	@Override
	public ProjetoEntity convertBeanToEntity(ProjetoBean bean) {

		ProjetoEntity entity = new ProjetoEntity();
		entity.setIdProjeto(bean.getId());
		entity.setClienteProjeto(new ClienteProjetoConverter.convertBeanToEntity(bean.getCliente()));
		entity.setFuncionario(new FuncionarioConverter.convertBeanToEntity(bean.getFuncionario()));
		entity.setNmProjeto(bean.getNome());
		return entity;
	}

	@Override
	public ProjetoBean convertEntityToBean(ProjetoEntity entity) {
		ProjetoBean bean = new ProjetoBean();
		bean.setId(entity.getIdProjeto());
		bean.setCliente(new ClienteProjetoConverter.convertEntityToBean(entity.getClienteProjeto()));
		bean.setFuncionario(new FuncionarioConverter.convertEntityToBean(entity.getFuncionario()));
		bean.setNome(entity.getNmProjeto());
		return bean
	}

}
