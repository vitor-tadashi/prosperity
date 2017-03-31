package br.com.verity.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Path("/servico")
@RequestMapping("/servico")
@Controller
public class VagasService {

	@GET
	@RequestMapping("/vagas-api")
	@Produces(MediaType.APPLICATION_JSON)
	public String vagasParaJSON() {
		System.out.println("Chegou aqui!");

		return "xablau";
	}
	
}
