package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.converter.VagaConverter;
import br.com.prosperity.dao.VagaDAO;
import br.com.prosperity.entity.VagaEntity;

@Component
public class VagaBusiness {

	@Autowired
	private VagaDAO vagaDAO;

	@Autowired
	VagaConverter vagaConverter;

	private VagaBean obter(int idVaga) {

		VagaEntity vagaEntity = vagaDAO.obterPorId(idVaga);

		VagaBean vagaBean = vagaConverter.convertEntityToBean(vagaEntity);

		return vagaBean;
	}

	public void inserir(VagaBean vagaBean) {
		vagaDAO.adicionar(vagaConverter.convertBeanToEntity(vagaBean));
	}

	public List<VagaBean> obterTodos() {
		List<VagaEntity> entities = vagaDAO.listar();
		List<VagaBean> beans = vagaConverter.convertEntityToBean(entities);
		return beans;
	}

}
