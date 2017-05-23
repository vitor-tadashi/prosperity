package br.com.prosperity.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CargoSenioridadeBean;
import br.com.prosperity.converter.CargoSenioridadeConverter;
import br.com.prosperity.dao.CargoSenioridadeDAO;
import br.com.prosperity.entity.CargoEntity;
import br.com.prosperity.entity.CargoSenioridadeEntity;
import br.com.prosperity.entity.SenioridadeEntity;

@Component
public class CargoSenioridadeBusiness {

	@Autowired
	private CargoSenioridadeDAO cargoSenioridadeDAO;

	@Autowired
	private CargoSenioridadeConverter cargoSenioridadeConverter;

	@Transactional(readOnly = true)
	public List<CargoSenioridadeBean> obterRangeSalarial(Integer cargo, Integer senioridade) {
		CargoEntity cargo1 = new CargoEntity();
		cargo1.setId(cargo);
		SenioridadeEntity senioridade1 = new SenioridadeEntity();
		senioridade1.setId(senioridade);
		List<CargoSenioridadeEntity> rangeSalarialEntity = cargoSenioridadeDAO.findByNamedQuery("rangeSalarial", cargo1,
				senioridade1);
		List<CargoSenioridadeBean> rangeSalarialBean = cargoSenioridadeConverter
				.convertEntityToBean(rangeSalarialEntity);
		return rangeSalarialBean;
	}
}