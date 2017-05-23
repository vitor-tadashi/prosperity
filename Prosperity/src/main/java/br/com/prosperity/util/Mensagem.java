package br.com.prosperity.util;

public class Mensagem {

	// tipo: se é vaga ou candidato
	// nome: nome do candidato ou da vaga
	// status: status atual que o algo recebe
	// usuario: para quem a mensagem está chegando

	public String gerador(String tipo, String nomeVagaOuCandidato, String status, String nomeUsuario) {

		String acaoASerTomada = definirAcao(tipo, status);
		String mensagem = "Olá " + nomeUsuario + " ,\nvocê está sendo notificado(a) que " + tipo + " "
				+ nomeVagaOuCandidato + " recebeu o status de \"" + status + "\"" + acaoASerTomada
				+ "\n\nAtenciosamente, equipe Prosperity.";

		return mensagem;
	}

	private String definirAcao(String tipo, String status) {

		String verbosComporFrase = " e deve ser ";

		if (tipo.contains("vaga")) {
			switch (status) {
			case "Pendente":
				return verbosComporFrase + "analisada.";
			case "Vaga nova":
				return verbosComporFrase + "trabalhada.";
			default:
				return ".";
			}
		} else if (tipo.contains("candidato")) {
			switch (status) {
			case "Contratado":
				return ".";
			case "Candidato em análise":
				return verbosComporFrase + "avaliado.";
			default:
				return ".";
			}
		}

		return ".";
	}
}