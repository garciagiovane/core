package com.garciagiovane.core;

public abstract class NotificationHandler {
	protected NotificationHandler proximaNotificacao;
	
	public NotificationHandler(NotificationHandler proximaNotificacao) {
		this.proximaNotificacao = proximaNotificacao;
	}
	
	public abstract String escolher(Request pedido);
	
	public String proximo(Request pedido) {
		return this.proximaNotificacao.escolher(pedido);
	}
}
