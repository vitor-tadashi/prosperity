package br.com.verity.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.thoughtworks.xstream.XStream;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.WordpressBean;
import br.com.prosperity.business.CandidatoBusiness;

@Path("/servico")
public class CandidatoService {

	@POST
	@Path("/can")
	@Consumes(MediaType.APPLICATION_XML)
	public void salvarBean(WordpressBean w) {
		System.out.println("Chegou aqui!");

		CandidatoBusiness b = new CandidatoBusiness();

		List<CandidatoBean> candidatos = new ArrayList<>();

		candidatos = w.getCandidatos();
		
		for (CandidatoBean c : candidatos) {
			b.inserir(c);
		}
	}
}
