package com.garciagiovane.core;

public class EmailNotificationHandler extends NotificationHandler {
	public EmailNotificationHandler(NotificationHandler nivel) {
		super(nivel);
	}
	
	@Override
	public String escolher(Request pedido) {
		if (pedido.getTipo().equals("email")) {
			return "Notificação via Email";
		} else {
			return proximo(pedido);
		}
	}
}
