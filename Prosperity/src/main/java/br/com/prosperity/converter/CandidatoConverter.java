package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.entity.CandidatoEntity;

@Component
public class CandidatoConverter implements Converter<CandidatoEntity, CandidatoBean> {

	@Autowired
	private ContatoConverter contatoConverter;

	@Autowired
	private CandidatoCompetenciaConverter candidatoCompetenciaConverter;

	@Autowired
	private EnderecoConverter enderecoConverter;

	@Autowired
	private FormacaoConverter formacaoConverter;

	@Autowired
	private UsuarioConverter usuarioConverter;

	@Autowired
	private VagaCandidatoConverter vagaCandidatoConverter;

	@Autowired
	private StatusCandidatoConverter statusCandidatoConverter;

	public CandidatoEntity convertBeanToEntityService(CandidatoBean bean) {
		if (bean == null) {
			return null;
		}

		CandidatoEntity entity = new CandidatoEntity();

		entity.setId(bean.getId());
		entity.setCpf(bean.getCpf());
		entity.setCurriculo(bean.getCurriculo());
		entity.setEmail(bean.getEmail());
		entity.setNome(bean.getNome());
		entity.setRg(bean.getRg());
		entity.setValorPretensao(bean.getValorPretensao());
		entity.setDataAbertura(bean.getDataAbertura());
		entity.setDataAlteracao(bean.getDataAlteracao());
		entity.setDataFechamento(bean.getDataFechamento());
		entity.setDataNascimento(bean.getDataNascimento());
		entity.setContato(contatoConverter.convertBeanToEntity(bean.getContato()));
		entity.setEndereco(enderecoConverter.convertBeanToEntity(bean.getEndereco()));
		entity.setCompetencias(candidatoCompetenciaConverter.convertBeanToEntity(bean.getCompetencias()));
		entity.setFormacao(formacaoConverter.convertBeanToEntity(bean.getFormacao()));
		entity.setUsuario(usuarioConverter.convertBeanToEntity(bean.getUsuario()));
		entity.setStatusCandidatos(statusCandidatoConverter.convertBeanToEntity(bean.getStatus()));
		entity.setDataEntrevista(bean.getEntrevista());
		entity.setDataUltimoContato(bean.getDataUltimoContato());
		entity.setProposta(bean.getProposta());
		entity.setVagas(vagaCandidatoConverter.convertBeanToEntity(bean.getVagas()));
		entity.setCurriculoTexto(bean.getCurriculoTexto());
		
		return entity;
	}

	public CandidatoEntity convertBeanToEntity(CandidatoEntity entity, CandidatoBean bean) {
		entity = convertFields(entity, bean);
		
		return entity;
	}
	
	@Override
	public CandidatoEntity convertBeanToEntity(CandidatoBean bean) {
		if (bean == null) {
			return null;
		}

		CandidatoEntity entity = new CandidatoEntity();

		entity.setId(bean.getId());
		entity = convertFields(entity, bean);

		return entity;
	}

	private CandidatoEntity convertFields(CandidatoEntity entity , CandidatoBean bean) {
		entity.setCpf(bean.getCpf());
		entity.setCurriculo(bean.getCurriculo());
		entity.setEmail(bean.getEmail());
		entity.setNome(bean.getNome());
		entity.setRg(bean.getRg());
		entity.setValorPretensao(bean.getValorPretensao());
		entity.setDataAbertura(bean.getDataAbertura());
		entity.setDataAlteracao(bean.getDataAlteracao());
		entity.setDataFechamento(bean.getDataFechamento());
		entity.setDataNascimento(bean.getDataNascimento());
		entity.setContato(contatoConverter.convertBeanToEntity(bean.getContato()));
		entity.setEndereco(enderecoConverter.convertBeanToEntity(bean.getEndereco()));
		entity.setCompetencias(candidatoCompetenciaConverter.convertBeanToEntity(bean.getCompetencias()));
		entity.setFormacao(formacaoConverter.convertBeanToEntity(bean.getFormacao()));
		entity.setUsuario(usuarioConverter.convertBeanToEntity(bean.getUsuario()));
		entity.setStatusCandidatos(statusCandidatoConverter.convertBeanToEntity(bean.getStatus()));
		entity.setDataEntrevista(bean.getEntrevista());
		entity.setDataUltimoContato(bean.getDataUltimoContato());
		entity.setProposta(bean.getProposta());
		entity.setCurriculoTexto(bean.getCurriculoTexto());
		if (entity.getVagas() == null || (entity.getVagas() != null && entity.getVagas().size() == 0)) {
			entity.setVagas(vagaCandidatoConverter.convertBeanToEntity(bean.getVagas()));
		}
		
		return entity;
	}

	@Override
	public CandidatoBean convertEntityToBean(CandidatoEntity entity) {
		if (entity == null) {
			return null;
		}

		CandidatoBean bean = new CandidatoBean();

		bean.setId(entity.getId());
		bean.setCpf(entity.getCpf());
		bean.setCurriculo(entity.getCurriculo());
		bean.setEmail(entity.getEmail());
		bean.setNome(entity.getNome());
		bean.setRg(entity.getRg());
		bean.setValorPretensao(entity.getValorPretensao());
		bean.setDataAbertura(entity.getDataAbertura());
		bean.setDataAlteracao(entity.getDataAlteracao());
		bean.setDataFechamento(entity.getDataFechamento());
		bean.setDataNascimento(entity.getDataNascimento());
		bean.setContato(contatoConverter.convertEntityToBean(entity.getContato()));
		bean.setEndereco(enderecoConverter.convertEntityToBean(entity.getEndereco()));
		bean.setCompetencias(candidatoCompetenciaConverter.convertEntityToBean(entity.getCompetencias()));
		bean.setFormacao(formacaoConverter.convertEntityToBean(entity.getFormacao()));
		bean.setUsuario(usuarioConverter.convertEntityToBean(entity.getUsuario()));
		bean.setStatus(statusCandidatoConverter.convertEntityToBean(entity.getStatusCandidatos()));
		bean.setEntrevista(entity.getDataEntrevista());
		bean.setDataUltimoContato(entity.getDataUltimoContato());
		bean.setProposta(entity.getProposta());
		bean.setVagas(vagaCandidatoConverter.convertEntityToBean(entity.getVagas()));
		bean.setCurriculoTexto(entity.getCurriculoTexto());
		return bean;
	}
}