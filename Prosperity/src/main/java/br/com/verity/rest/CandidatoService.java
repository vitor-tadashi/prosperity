package br.com.verity.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.business.CandidatoBusiness;

@Path("servico")
public class CandidatoService {
	
	@POST
	@Consumes("aplication/xml")
	public void salvarBean(List<CandidatoBean> candidatos) {
		
		System.out.println("Entrou");
		
		CandidatoBusiness b = new CandidatoBusiness();
		
		for (CandidatoBean c : candidatos) {
			b.inserir(c);
		}
	}
}
