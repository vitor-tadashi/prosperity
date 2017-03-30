package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.entity.CargoEntity;

@Component
public class CargoConverter implements Converter<CargoEntity, CargoBean> {

	@Override
	public CargoEntity convertBeanToEntity(CargoBean bean) {
		if (bean == null) {
			return null;
		}
		CargoEntity entity = new CargoEntity();
		entity.setId(bean.getId());
		entity.setNome(bean.getNome());
		return entity;
	}

	@Override
	public CargoBean convertEntityToBean(CargoEntity entity) {
		if (entity == null) {
			return null;
		}
		CargoBean bean = new CargoBean();

		bean.setId(entity.getId());
		bean.setNome(entity.getNome());

		return bean;

	}
}