package br.com.prosperity.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jersey.api.json.JSONWithPadding;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.VagaBusiness;

@RestController
public class VagasService {

	@Autowired
	private VagaBusiness vagaBusiness;
	
	@CrossOrigin
	@RequestMapping(value="/vagas-api", produces="application/json")
	public @ResponseBody JSONWithPadding vagasParaJSON() {
		System.out.println("Chegou aqui!");
		List<VagaBean> vagas = vagaBusiness.listar();
		
		return new JSONWithPadding(vagas);
		//Gson gson = new Gson();
		//return gson.toJson(vagas);
	}
	
}
