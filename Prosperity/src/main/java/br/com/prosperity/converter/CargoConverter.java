package br.com.prosperity.converter;

import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.entity.CargoEntity;

@Component
public class CargoConverter implements Converter<CargoEntity, CargoBean> {

	@Override
	public CargoEntity convertBeanToEntity(CargoBean bean) {
		CargoEntity entity = new CargoEntity();
		if (bean == null) {
			entity = null;
		} else {
			entity.setId(bean.getId());
			entity.setNome(bean.getNome());
		}
		return entity;
	}

	@Override
	public CargoBean convertEntityToBean(CargoEntity entity) {
		CargoBean bean = new CargoBean();
		if (entity == null) {
			bean = null;
		} else {
			bean.setId(entity.getId());
			bean.setNome(entity.getNome());
		}
		return bean;

	}
}