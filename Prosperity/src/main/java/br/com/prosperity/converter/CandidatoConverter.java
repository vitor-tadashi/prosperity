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
		entity.setContatos(contatoConverter.convertBeanToEntity(bean.getContatos()));
		entity.setEndereco(enderecoConverter.convertBeanToEntity(bean.getEndereco()));

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
		bean.setContatos(contatoConverter.convertEntityToBean(entity.getContatos()));
		bean.setEndereco(enderecoConverter.convertEntityToBean(entity.getEndereco()));
		return bean;
	}
}