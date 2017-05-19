package br.com.prosperity.util;

public class Mensagem {
	
	// tipo: se é vaga ou candidato
	// nome: nome do candidato ou da vaga
	// status: status atual que o algo recebe
	// usuario: para quem a mensagem está chegando
	
	public String gerador(String tipo, String nomeVagaOuCandidato, String status, String nomeUsuario) {
		
		String mensagem = "Olá " + nomeUsuario + " ,\nvocê está sendo notificado(a) que " + tipo 
				+ " " + nomeVagaOuCandidato + " recebeu o status de "
				+ status + "\n\natenciosamente, equipe Prosperity.";
		
		return mensagem;
	}
}
