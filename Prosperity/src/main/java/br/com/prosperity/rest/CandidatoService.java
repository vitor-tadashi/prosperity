package br.com.prosperity.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.WordpressBean;
import br.com.prosperity.business.CandidatoBusiness;

@RestController
public class CandidatoService {
	@Autowired
	private CandidatoBusiness b;
	
	@POST
	@RequestMapping("/servico")
	@Consumes("application/xml")
	public void salvarBean(@RequestBody WordpressBean w) {
		
		System.out.println("Chegou aqui!");

		List<CandidatoBean> candidatos = new ArrayList<>();

		candidatos = w.getCandidatos();

		for (CandidatoBean c : candidatos) {
			b.inserir(c);
		}
	}
}
