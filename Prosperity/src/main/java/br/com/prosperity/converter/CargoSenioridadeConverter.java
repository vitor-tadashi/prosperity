package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CargoSenioridadeBean;
import br.com.prosperity.entity.CargoSenioridadeEntity;

@Component
public class CargoSenioridadeConverter implements Converter<CargoSenioridadeEntity, CargoSenioridadeBean> {

	@Autowired
	CargoConverter cargoConverter;

	@Autowired
	SenioridadeConverter senioridadeConverter;

	@Override
	public CargoSenioridadeEntity convertBeanToEntity(CargoSenioridadeBean bean) {
		if (bean == null) {
			return null;
		}
		CargoSenioridadeEntity entity = new CargoSenioridadeEntity();

		entity.setId(bean.getId());
		entity.setCargo(cargoConverter.convertBeanToEntity(bean.getCargos()));
		entity.setIdSenioridade(senioridadeConverter.convertBeanToEntity(bean.getSenioridades()));
		entity.setVlMaxSalario(bean.getValorMaxSalario());
		entity.setVlMinSalario(bean.getValorMinSalario());
		entity.setDsPreFormacaoAcademica(bean.getDsPreFormacaoAcademica());
		entity.setDsPrePerfilComportamental(bean.getDsPrePerfilComportamental());
		entity.setDsPrePerfilTecnico(bean.getDsPrePerfilTecnico());

		return entity;
	}

	@Override
	public CargoSenioridadeBean convertEntityToBean(CargoSenioridadeEntity entity) {
		if (entity == null) {
			return null;
		}
		CargoSenioridadeBean bean = new CargoSenioridadeBean();

		bean.setId(bean.getId());
		bean.setCargos(cargoConverter.convertEntityToBean(entity.getCargo()));
		bean.setSenioridades(senioridadeConverter.convertEntityToBean(entity.getIdSenioridade()));
		bean.setValorMaxSalario(entity.getVlMaxSalario());
		bean.setValorMinSalario(entity.getVlMinSalario());
		bean.setDsPreFormacaoAcademica(entity.getDsPreFormacaoAcademica());
		bean.setDsPrePerfilComportamental(entity.getDsPrePerfilComportamental());
		bean.setDsPrePerfilTecnico(entity.getDsPrePerfilTecnico());

		return bean;
	}
}