package com.garciagiovane.core.notificacao;

public class Email implements Estrategia{
	@Override
	public String enviarNotificacao() {
		return "Email";
	}
}
