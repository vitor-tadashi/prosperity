package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ProjetoBean;
import br.com.prosperity.entity.ProjetoEntity;

@Component
public class ProjetoConverter implements Converter<ProjetoEntity, ProjetoBean> {

	@Autowired
	private FuncionarioConverter funcionarioConverter;
	@Autowired
	private ClienteConverter clienteConverter;

	@Override
	public ProjetoEntity convertBeanToEntity(ProjetoBean bean) {
		if (bean == null) {
			return null;
		}
		ProjetoEntity entity = new ProjetoEntity();
		entity.setIdProjeto(bean.getId());
		entity.setNmProjeto(bean.getNome());
		entity.setFuncionario(funcionarioConverter.convertBeanToEntity(bean.getFuncionario()));
		entity.setClienteProjeto(clienteConverter.convertBeanToEntity(bean.getCliente()));
		// entity.setPerfilEntity(perfilConverter.convertBeanToEntity(bean.getPerfil()));

		return entity;
	}

	@Override
	public ProjetoBean convertEntityToBean(ProjetoEntity entity) {
		if (entity == null) {
			return null;
		}
		ProjetoBean bean = new ProjetoBean();

		bean.setId(entity.getIdProjeto());
		bean.setNome(entity.getNmProjeto());
		bean.setFuncionario(funcionarioConverter.convertEntityToBean(entity.getFuncionario()));
		bean.setCliente(clienteConverter.convertEntityToBean(entity.getClienteProjeto()));

		return bean;
	}
}
