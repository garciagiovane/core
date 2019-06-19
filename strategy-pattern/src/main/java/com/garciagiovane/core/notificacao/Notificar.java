package com.garciagiovane.core.notificacao;

import com.garciagiovane.core.cliente.Cliente;
public class Notificar {

	public static void main(String[] args) {
		Contexto contexto = new Contexto(new Email());
		System.out.println(contexto.executarEstrategia(new Mensagem(new Cliente("Giovane", "giovane@mail.com", null))));
		
		contexto = new Contexto(new SMS());
		System.out.println(contexto.executarEstrategia(new Mensagem(new Cliente("Marcela", "marcela@mail.com", "(51) 85361-5241"))));
	}
}
