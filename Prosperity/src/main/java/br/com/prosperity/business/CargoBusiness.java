package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.TipoCursoBean;
import br.com.prosperity.converter.CargoConverter;
import br.com.prosperity.dao.CargoDAO;
import br.com.prosperity.entity.CargoEntity;

@Component
public class CargoBusiness {

	@Autowired
	private CargoDAO cargoDAO;

	@Autowired
	private CargoConverter cargoConverter;

	@Transactional
	public List<CargoBean> obterTodos() {
		List<CargoEntity> cargoEntity = cargoDAO.listar();
		List<CargoBean> cargoBean = cargoConverter.convertEntityToBean(cargoEntity);
		return cargoBean;
	}

	@Transactional(readOnly=true)
	public CargoEntity obterPorId(Integer id) {
		CargoEntity entity = cargoDAO.obterPorId(id);
		return entity;
	}

}
