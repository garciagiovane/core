package com.garciagiovane.core.notificacao;

public class SMS implements Estrategia{
	@Override
	public String enviarNotificacao() {
		return "SMS";
	}
}
