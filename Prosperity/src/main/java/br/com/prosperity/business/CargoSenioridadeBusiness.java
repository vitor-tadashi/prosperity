package br.com.prosperity.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.bean.CargoSenioridadeBean;
import br.com.prosperity.bean.SenioridadeBean;
import br.com.prosperity.converter.CargoConverter;
import br.com.prosperity.converter.CargoSenioridadeConverter;
import br.com.prosperity.converter.SenioridadeConverter;
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
	@Autowired
	private SenioridadeConverter senioridadeConverter;
	@Autowired
	private CargoConverter cargoConverter;
	
	@Transactional(readOnly=true)
	public List<CargoSenioridadeBean> obterRangeSalarial(CargoBean cargo,SenioridadeBean senioridade) {
		CargoEntity cargo1 = cargoConverter.convertBeanToEntity(cargo);
		List<CargoEntity> cargoEntity = new ArrayList<>();
		cargoEntity.add(cargo1);
		SenioridadeEntity senioridade1 = senioridadeConverter.convertBeanToEntity(senioridade);
		List<SenioridadeEntity> senioridadeEntity = new ArrayList<>();
		senioridadeEntity.add(senioridade1);
		List<CargoSenioridadeEntity> rangeSalarialEntity = cargoSenioridadeDAO.findByNamedQuery("rangeSalarial", cargoEntity,senioridadeEntity);
		List<CargoSenioridadeBean> rangeSalarialBean = cargoSenioridadeConverter.convertEntityToBean(rangeSalarialEntity);
		return rangeSalarialBean;
	}

}
