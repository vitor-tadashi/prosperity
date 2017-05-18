package br.com.prosperity.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.PropostaBean;
import br.com.prosperity.converter.PropostaConverter;
import br.com.prosperity.dao.PropostaDAO;
import br.com.prosperity.entity.PropostaEntity;

@Component
public class PropostaBusiness {

	@Autowired
	private PropostaDAO propostaDAO;
	
	@Autowired
	private PropostaConverter propostaConverter;
	
	@Transactional
	public void inserir(List<PropostaBean> beans) {
		List<PropostaEntity> entitys = propostaConverter.convertBeanToEntity(beans);
		for(PropostaEntity entity : entitys){
			propostaDAO.insert(entity);
		}
	}
}
