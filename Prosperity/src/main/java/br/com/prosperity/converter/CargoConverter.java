package br.com.prosperity.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.prosperity.bean.CargoBean;
import br.com.prosperity.entity.CargoEntity;

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

	@Override
	public List<CargoBean> convertEntityToBean(List<CargoEntity> entities) {
		List<CargoBean> beanList = new ArrayList<>();
		for (CargoEntity e : entities) {
			beanList.add(convertEntityToBean(e));

		}
		return beanList;
	}
}