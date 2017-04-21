package br.com.prosperity.util;

import br.com.prosperity.bean.CandidatoBean;
import br.com.prosperity.bean.ContatoBean;

public class FormatUtil {

	public static CandidatoBean formatCPF(CandidatoBean candidatoBean) {
		if(candidatoBean != null){
		String bloco1 = candidatoBean.getCpf().substring(0, 3);
		String bloco2 = candidatoBean.getCpf().substring(3, 6);
		String bloco3 = candidatoBean.getCpf().substring(6, 9);
		String bloco4 = candidatoBean.getCpf().substring(9, 11);

		candidatoBean.setCpf(String.format("%s.%s.%s-%s", bloco1, bloco2, bloco3, bloco4));
		}
		return candidatoBean;
	}

	public static CandidatoBean formatRG(CandidatoBean candidatoBean) {
		if(candidatoBean != null){
		String bloco1 = candidatoBean.getRg().substring(0, 2);
		String bloco2 = candidatoBean.getRg().substring(2, 5);
		String bloco3 = candidatoBean.getRg().substring(5, 8);
		String bloco4 = candidatoBean.getRg().substring(8, 9);

		candidatoBean.setRg(String.format("%s.%s.%s-%s", bloco1, bloco2, bloco3, bloco4));
		}
		return candidatoBean;
	}

	public static ContatoBean formatPhone(ContatoBean contatoBean) {
		if (contatoBean != null) {
			//11971245007
			//(11)97124-5007
			String bloco1;
			String bloco2;
			String bloco3;
			contatoBean.getTelefone().
			
			if(contatoBean.getTelefone().length() == 11) {
				bloco1 = contatoBean.getTelefone().substring(0, 2);
				bloco2 = contatoBean.getTelefone().substring(2, 7);
				bloco3 = contatoBean.getTelefone().substring(7, 11);
			} else {
				bloco1 = contatoBean.getTelefone().substring(0, 2);
				bloco2 = contatoBean.getTelefone().substring(2, 6);
				bloco3 = contatoBean.getTelefone().substring(6, 10);
			}

			contatoBean.setTelefone(String.format("(%s) %s-%s", bloco1, bloco2, bloco3));

		}
		return contatoBean;
	}
	
}
