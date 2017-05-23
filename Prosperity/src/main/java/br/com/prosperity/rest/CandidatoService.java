package br.com.prosperity.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.WordpressBean;
import br.com.prosperity.business.CandidatoBusiness;
import br.com.prosperity.exception.BusinessException;

@RestController
public class CandidatoService {
	@Autowired
	private CandidatoBusiness candidatoBusiness;

	@POST
	@RequestMapping(value = "/servico")
	@Consumes("application/json")
	public void salvarBean(@RequestBody String json) {

		Gson gson = new GsonBuilder().create();
		WordpressBean w = gson.fromJson(json, WordpressBean.class);
		
		List<CandidatoBean> candidatos = new ArrayList<>();

		candidatos = w.getCandidatos();

		if (!candidatos.isEmpty())
			for (CandidatoBean c : candidatos) {
				try {
					candidatoBusiness.inserirWordpress(c);
				} catch (BusinessException e) {
					e.printStackTrace();
				}
			}
	}
}
