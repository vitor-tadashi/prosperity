package br.com.prosperity.converter;

import br.com.prosperity.bean.CargoSenioridadeBean;
import br.com.prosperity.entity.CargoSenioridadeEntity;

public class CargoSenioridadeConverter implements Converter<CargoSenioridadeEntity, CargoSenioridadeBean> {

	@Override
	public CargoSenioridadeEntity convertBeanToEntity(CargoSenioridadeBean bean) {
		CargoSenioridadeEntity entity = new CargoSenioridadeEntity();
		entity.setId(bean.getId());
		entity.setVlMaxSalario(bean.getValorMaxSalario());
		entity.setVlMaxSalario(bean.getValorMinSalario());
		return entity;
	}

	@Override
	public CargoSenioridadeBean convertEntityToBean(CargoSenioridadeEntity entity) {
		CargoSenioridadeBean bean = new CargoSenioridadeBean();
		bean.setId(bean.getId());
		bean.setValorMaxSalario(entity.getVlMaxSalario());
		bean.setValorMaxSalario(entity.getVlMinSalario());
		return bean;
	}
}
