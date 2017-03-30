package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CargoSenioridadeBean;
import br.com.prosperity.entity.CargoSenioridadeEntity;

@Component
public class CargoSenioridadeConverter implements Converter<CargoSenioridadeEntity, CargoSenioridadeBean> {

	@Autowired
	private CargoConverter cargoConverter;

	@Override
	public CargoSenioridadeEntity convertBeanToEntity(CargoSenioridadeBean bean) {
		if (bean == null) {
			return null;
		}

		CargoSenioridadeEntity entity = new CargoSenioridadeEntity();
		entity.setId(bean.getId());
		entity.setVlMaxSalario(bean.getValorMaxSalario());
		entity.setVlMaxSalario(bean.getValorMinSalario());
		return entity;
	}

	@Override
	public CargoSenioridadeBean convertEntityToBean(CargoSenioridadeEntity entity) {
		if (entity == null) {
			return null;
		}
		CargoSenioridadeBean bean = new CargoSenioridadeBean();
		bean.setId(bean.getId());
		// conversor de conversor
		bean.setValorMaxSalario(entity.getVlMaxSalario());
		bean.setValorMaxSalario(entity.getVlMinSalario());
		return bean;
	}
}
