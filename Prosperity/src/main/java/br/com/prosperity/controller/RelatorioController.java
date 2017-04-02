package br.com.prosperity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prosperity.business.RelatorioBusiness;
import br.com.prosperity.entity.VagaEntity;
import br.com.prosperity.enumarator.StatusVagaEnum;

@Controller
@RequestMapping("relatorio")
public class RelatorioController {
	
	@Autowired
	private RelatorioBusiness relatorioBusiness;
	
	@RequestMapping(method = RequestMethod.GET)
	public String relatorio(Model model) {
		List<VagaEntity> vagas = relatorioBusiness.listarVagas();
		model.addAttribute("vagas", vagas);
		StatusVagaEnum[] situacoes = StatusVagaEnum.values();
		model.addAttribute("situacoes", situacoes);
		return "relatorio/gerar-relatorio";
	}
	
	@RequestMapping(value="/gerar", method = RequestMethod.POST)
	public String gerar(Model model) {
		return "relatorio/gerar-relatorio";
	}

}
