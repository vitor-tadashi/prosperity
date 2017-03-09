package br.com.prosperity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prosperity.bean.FuncionarioBean;
import br.com.prosperity.bean.ProjetoBean;

@Component
public class ProjetoConverter  {
	
	@Autowired
	private FuncionarioConverter funcionarioConverter;

}
