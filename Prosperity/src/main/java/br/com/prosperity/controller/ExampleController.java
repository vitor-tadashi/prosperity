package br.com.prosperity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.bean.ExampleBean;
import br.com.prosperity.business.ExampleBusiness;

@Controller
@RequestMapping("example")
public class ExampleController {

	@Autowired
	private ExampleBusiness exampleBusiness;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String cadastrarCandidato() {
		return "example/example";
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String inserir(ExampleBean exampleBean) {
		exampleBusiness.inserir(exampleBean);
		return "example/consulta";
	}
}
