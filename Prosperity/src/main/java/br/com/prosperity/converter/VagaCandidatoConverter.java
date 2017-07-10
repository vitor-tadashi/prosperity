package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.VagaCandidatoBean;
import br.com.prosperity.entity.VagaCandidatoEntity;

@Component
public class VagaCandidatoConverter implements Converter<VagaCandidatoEntity, VagaCandidatoBean> {

	@Autowired
	private CanalInformacaoConverter canalInformacaoConverter;

	@Override
	public VagaCandidatoEntity convertBeanToEntity(VagaCandidatoBean bean) {
		if (bean == null) {
			return null;
		}
		VagaCandidatoEntity entity = new VagaCandidatoEntity();
		entity.setIdVagaCandidato(bean.getId());
		entity.setCanalInformacao(canalInformacaoConverter.convertBeanToEntity(bean.getCanalInformacao()));
		entity.setContratado(bean.getContratado());
		entity.setOutros(bean.getOutros());
		entity.setNmFuncionario(bean.getNomeFuncionario());;

		return entity;
	}

	@Override
	public VagaCandidatoBean convertEntityToBean(VagaCandidatoEntity entity) {
		if (entity == null) {
			return null;
		}
		VagaCandidatoBean bean = new VagaCandidatoBean();
		bean.setId(entity.getIdVagaCandidato());
		bean.setCanalInformacao(canalInformacaoConverter.convertEntityToBean(entity.getCanalInformacao()));
		bean.setContratado(entity.getContratado());
		bean.setOutros(entity.getOutros());
		bean.setNomeFuncionario(entity.getNmFuncionario());

		return bean;
	}
}