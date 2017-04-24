package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CargoSenioridadeBean;
import br.com.prosperity.converter.CargoSenioridadeConverter;
import br.com.prosperity.dao.CargoSenioridadeDAO;
import br.com.prosperity.entity.CargoSenioridadeEntity;

@Component
public class CargoSenioridadeBusiness {

	@Autowired
	private CargoSenioridadeDAO cargoSenioridadeDAO;
	@Autowired
	private CargoSenioridadeConverter cargoSenioridadeConverter;

	@Transactional(readOnly = true)
	public List<CargoSenioridadeBean> obterRangeSalarial(Integer idCargo, Integer idSenioridade) {
		List<CargoSenioridadeEntity> rangeSalarialEntity = cargoSenioridadeDAO.findByNamedQuery("rangeSalarial",
				idCargo, idSenioridade);
		List<CargoSenioridadeBean> rangeSalarialBean = cargoSenioridadeConverter
				.convertEntityToBean(rangeSalarialEntity);
		return rangeSalarialBean;
	}

}
