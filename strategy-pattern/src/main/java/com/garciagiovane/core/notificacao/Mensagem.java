package com.garciagiovane.core.notificacao;
import com.garciagiovane.core.cliente.Cliente;

public class Mensagem {
	private Cliente cliente;
	
	public Mensagem(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String criarMensagem() {
		return "Olá " + this.cliente.getNome() + ", você foi notificado(a) via ";
	}
}
