package com.garciagiovane.core;

public class CartaNotificationHandler extends NotificationHandler {
	public CartaNotificationHandler(NotificationHandler nivel) {
		super(nivel);
	}
	
	@Override
	public String escolher(Request pedido) {
		if (pedido.getTipo().equals("carta")) {
			return "Notificação via Carta";
		} else {
			return proximo(pedido);
		}
	}
}
