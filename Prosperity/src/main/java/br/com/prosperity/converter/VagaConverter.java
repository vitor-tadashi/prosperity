
package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.entity.VagaEntity;

@Component
public class VagaConverter implements Converter<VagaEntity, VagaBean> {

	@Autowired
	private SenioridadeConverter senioridadeConverter;

	@Autowired
	private CargoConverter cargoConverter;

	@Autowired
	private ProjetoConverter projetoConverter;

	@Autowired
	private StatusVagaConverter statusVagaConverter;

	@Autowired
	private UsuarioConverter usuarioConverter;

	@Override
	public VagaEntity convertBeanToEntity(VagaBean bean) {
		
		if (bean == null) {
			return null;
		}
		
		VagaEntity entity = new VagaEntity();

		entity.setId(bean.getId());
		entity.setNomeVaga(bean.getNomeVaga());
		entity.setAumentoQuadro(bean.getAumentaQuadro());
		entity.setCargoEntity(cargoConverter.convertBeanToEntity(bean.getCargoBean()));
		entity.setDataAbertura(bean.getDataAbertura());
		entity.setDataAprovacao(bean.getDataAprovacao());
		entity.setDataFechamento(bean.getDataFechamento());
		entity.setDataInicio(bean.getDataInicio());
		entity.setDescricaoFormacaoAcademica(bean.getDescricaoFormacaoAcademica());
		entity.setDescricaoPerfilComportamental(bean.getDescricaoPerfilComportamental());
		entity.setDescricaoPerfilTecnico(bean.getDescricaoPerfilTecnico());
		entity.setHoraEntrada(bean.getHorarioEntrada());
		entity.setHoraSaida(bean.getHorarioSaida());
		entity.setLocalTrabalho(bean.getLocalTrabalho());
		entity.setNomeSolicitante(bean.getNomeSolicitante());
		entity.setNomeSubstituido(bean.getNomeSubstituido());
		entity.setNumeroCandidatos(bean.getNumeroCandidatos());
		entity.setProjetoEntity(projetoConverter.convertBeanToEntity(bean.getProjeto()));
		entity.setSenioridadeEntity(senioridadeConverter.convertBeanToEntity(bean.getSenioridadeBean()));
		entity.setTipoVaga(bean.getIdTipoVaga());
		entity.setValorPretensao(bean.getValorPretensao());
		entity.setUsuarioEntity(usuarioConverter.convertBeanToEntity(bean.getUsuarioBean()));
		entity.setStatusVagaEntity(statusVagaConverter.convertBeanToEntity(bean.getStatus()));

		entity.setNmResponsavel(bean.getNmResponsavel());
		entity.setNmAreaResponsavel(bean.getNmAreaResponsavel());
		entity.setEmailResponsavel(bean.getEmailResponsavel());
		entity.setTelResponsavel(bean.getTelResponsavel());


		return entity;

	}

	@Override
	public VagaBean convertEntityToBean(VagaEntity entity) {
		
		if (entity == null) {
			return null;
		}
		
		VagaBean bean = new VagaBean();

		bean.setId(entity.getId());
		bean.setNomeVaga(entity.getNomeVaga());
		bean.setAumentaQuadro(entity.getAumentoQuadro());
		bean.setCargoBean(cargoConverter.convertEntityToBean(entity.getCargoEntity()));
		bean.setDataAbertura(entity.getDataAbertura());
		bean.setDataAprovacao(entity.getDataAprovacao());
		bean.setDataFechamento(entity.getDataFechamento());
		bean.setDataInicio(entity.getDataInicio());
		bean.setDescricaoFormacaoAcademica(entity.getDescricaoFormacaoAcademica());
		bean.setDescricaoPerfilComportamental(entity.getDescricaoPerfilComportamental());
		bean.setDescricaoPerfilTecnico(entity.getDescricaoPerfilTecnico());
		bean.setHorarioEntrada(entity.getHoraEntrada());
		bean.setHorarioSaida(entity.getHoraSaida());
		bean.setLocalTrabalho(entity.getLocalTrabalho());
		bean.setNomeSolicitante(entity.getNomeSolicitante());
		bean.setNomeSubstituido(entity.getNomeSubstituido());
		bean.setNumeroCandidatos(entity.getNumeroCandidatos());
		bean.setProjeto(projetoConverter.convertEntityToBean(entity.getProjetoEntity()));
		bean.setSenioridadeBean(senioridadeConverter.convertEntityToBean(entity.getSenioridadeEntity()));
		bean.setIdTipoVaga(entity.getTipoVaga());
		bean.setValorPretensao(entity.getValorPretensao());
		bean.setUsuarioBean(usuarioConverter.convertEntityToBean(entity.getUsuarioEntity()));
		bean.setStatus(statusVagaConverter.convertEntityToBean(entity.getStatusVagaEntity()));
		bean.setNmResponsavel(entity.getNmResponsavel());
		bean.setNmAreaResponsavel(entity.getNmAreaResponsavel());
		bean.setEmailResponsavel(entity.getEmailResponsavel());
		bean.setTelResponsavel(entity.getTelResponsavel());

		return bean;
	}

	/*
	 * public List<VagaBean> convertEntityToBean(List<VagaEntity> entities) {
	 * List<VagaBean> beans = new ArrayList<VagaBean>();
	 * 
	 * for(VagaEntity entity : entities){
	 * beans.add(convertEntityToBean(entity)); } return beans; }
	 */
}
