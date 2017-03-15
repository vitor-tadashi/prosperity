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
	private AvaliacaoConverter avalicaoConverter;
	
	@Autowired
	private CandidatoCompetenciaConverter candidatoCompetenciaConverter;

	@Autowired
	private EnderecoConverter enderecoConverter;
	
	@Autowired
	private FormacaoConverter formacaoConverter;

	@Override
	public CandidatoEntity convertBeanToEntity(CandidatoBean bean) {
		CandidatoEntity entity = new CandidatoEntity();
		entity.setId(bean.getId());
		entity.setCpf(bean.getCpf());
		entity.setCurriculo(bean.getCurriculo());
		entity.setEmail(bean.getEmail());
		entity.setNome(bean.getNome());
		entity.setRg(bean.getRg());
		entity.setValorPretensaoSalarial(bean.getValorPretensao());
		entity.setDataAbertura(bean.getDataAbertura());
		entity.setDataAlteracao(bean.getDataAlteracao());
		entity.setDataNascimento(bean.getDataNascimento());
		entity.setFormacao(formacaoConverter.convertBeanToEntity(bean.getFormacao()));
		entity.setContato(contatoConverter.convertBeanToEntity(bean.getContato()));
		entity.setEndereco(enderecoConverter.convertBeanToEntity(bean.getEndereco()));
		entity.setCandidatoCompetencia(candidatoCompetenciaConverter.convertBeanToEntity(bean.getCompetencias()));
		entity.setDataEntrevista(bean.getEntrevista());
		entity.setDataUltimoContato(bean.getUltimoContato());
		entity.setProposta(bean.getProposta());
		

		return entity;
	}

	@Override
	public CandidatoBean convertEntityToBean(CandidatoEntity entity) {
		CandidatoBean bean = new CandidatoBean();
		bean.setId(entity.getId());
		bean.setCpf(entity.getCpf());
		bean.setCurriculo(entity.getCurriculo());
		bean.setEmail(entity.getEmail());
		bean.setNome(entity.getNome());
		bean.setRg(entity.getRg());
		bean.setValorPretensao(entity.getValorPretensaoSalarial());
		bean.setDataAbertura(entity.getDataAbertura());
		bean.setDataAlteracao(entity.getDataAlteracao());
		bean.setDataFechamento(entity.getDataFechamento());
		bean.setDataNascimento(entity.getDataNascimento());
		bean.setFormacao(formacaoConverter.convertEntityToBean(entity.getFormacao()));
		bean.setContato(contatoConverter.convertEntityToBean(entity.getContato()));
		bean.setEndereco(enderecoConverter.convertEntityToBean(entity.getEndereco()));
		bean.setCompetencias(candidatoCompetenciaConverter.convertEntityToBean(entity.getCandidatoCompetencia()));
		bean.setEntrevista(entity.getDataEntrevista());
		bean.setUltimoContato(entity.getDataUltimoContato());
		bean.setProposta(entity.getProposta());
		
		return bean;
	}
}