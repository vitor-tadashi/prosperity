package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.prosperity.bean.FuncionalidadeBean;
import br.com.prosperity.converter.FuncionalidadeConverter;
import br.com.prosperity.dao.FuncionalidadeDAO;
import br.com.prosperity.entity.FuncionalidadeEntity;

public class FuncionalidadeBusiness {
	@Autowired
	private FuncionalidadeDAO funcionalidadeDAO;

	@Autowired
	private FuncionalidadeConverter funcionalidadeConverter;

	public List<FuncionalidadeBean> obterTodos() {
		List<FuncionalidadeEntity> funcionalidadeEntity = funcionalidadeDAO.listar();
		List<FuncionalidadeBean> funcionalidadeBean = funcionalidadeConverter
				.convertListEntityToBean(funcionalidadeEntity);

		return funcionalidadeBean;
	}
}
