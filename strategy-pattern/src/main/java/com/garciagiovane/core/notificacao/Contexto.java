package com.garciagiovane.core.notificacao;

public class Contexto {
	private Estrategia estrategia;
	
	public Contexto(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
	
	public String executarEstrategia(Mensagem mensagem) {
		return mensagem.criarMensagem() + estrategia.enviarNotificacao();
	}
}
