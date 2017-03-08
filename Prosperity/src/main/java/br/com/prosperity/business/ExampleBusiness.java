package br.com.prosperity.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.prosperity.bean.ExampleBean;
import br.com.prosperity.converter.ExampleConverter;
import br.com.prosperity.dao.ExampleDAO;

@Component
public class ExampleBusiness {

	@Autowired
	private ExampleDAO exampleDAO;
	
	@Autowired
	private ExampleConverter exampleConverter;

	public void inserir(ExampleBean exampleBean) {
		exampleDAO.adicionar(exampleConverter.convertBeanToEntity(exampleBean));
	}
}
