package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.entity.CargoEntity;

@Component
public class CargoConverter implements Converter<CargoEntity, CargoBean> {

	@Override
	public CargoEntity convertBeanToEntity(CargoBean bean) {
		CargoEntity entity = new CargoEntity();
		entity.setId(bean.getId());
		return entity;
	}

	@Override
	public CargoBean convertEntityToBean(CargoEntity entity) {
		CargoBean bean = new CargoBean();
		bean.setId(entity.getId());
		return bean;

	}
}