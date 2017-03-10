package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.ProjetoBean;
import br.com.prosperity.entity.ProjetoEntity;

@Component
public class ProjetoConverter  implements Converter<ProjetoEntity, ProjetoBean>  {
	
	@Autowired
	ClienteConverter cliente;
	
	@Autowired
	FuncionarioConverter funcionario;
	
	@Override
	public ProjetoEntity convertBeanToEntity(ProjetoBean bean) {
		ProjetoEntity entity = new ProjetoEntity();
		entity.setIdProjeto(bean.getId());
		entity.setNmProjeto(bean.getNome());
		//entity.setClienteProjeto(cliente.convertBeanToEntity(bean.getCliente()));
		//entity.setFuncionario(funcionario.convertBeanToEntity(bean.getFuncionario()));
		return entity;
	}

	@Override
	public ProjetoBean convertEntityToBean(ProjetoEntity entity) {
		ProjetoBean bean = new ProjetoBean();
		bean.setId(entity.getIdProjeto());
		bean.setNome(entity.getNmProjeto());
		//bean.setCliente(cliente.convertEntityToBean(entity.getClienteProjeto()));
		//bean.setFuncionario(funcionario.convertEntityToBean(entity.getFuncionario()));
		return bean;
	}
}
