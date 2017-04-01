package br.com.prosperity.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.prosperity.bean.VagaBean;
import br.com.prosperity.business.VagaBusiness;

@RestController
public class VagasService {

	@Autowired
	private VagaBusiness vagaBusiness;
	
	@RequestMapping(value="/vagas-api", method=RequestMethod.GET)
	public @ResponseBody String vagasParaJSON() {
		System.out.println("Chegou aqui!");
		List<VagaBean> vagas = vagaBusiness.listar();
		Gson gson = new Gson();
		return gson.toJson(vagas);
	}
	
}
