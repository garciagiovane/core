package com.garciagiovane.core;

public class SMSNotificationHandler extends NotificationHandler {
	public SMSNotificationHandler(NotificationHandler nivel) {
		super(nivel);
	}
	@Override
	public String escolher(Request pedido) {
		if (pedido.getTipo().equals("sms")) {
			return "Notificação via SMS";
		} else {
			return proximo(pedido);
		}
	}
}
