package br.com.prosperity.util;

public class Mensagem {
	
	// tipo: se é vaga ou candidato
	// nome: nome do candidato ou da vaga
	// status: status atual que o algo recebe
	// usuario: para quem a mensagem está chegando
	
	public String gerador(String tipo, String nome, String status, String usuario) {
		
		String mensagem = "Olá " + usuario + " ,\nvocê está sendo notificado(a) que " + tipo 
				+ " " + nome + " recebeu o status de "
				+ status + "\n\natenciosamente, equipe Prosperity.";
		
		return mensagem;
	}
}
