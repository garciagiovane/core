package com.garciagiovane.core;

public class Notificar {
	public static void main(String[] args) {
		NotificationHandler emailNotification = new EmailNotificationHandler(null);
		NotificationHandler smsNotification = new SMSNotificationHandler(emailNotification);
		NotificationHandler cartaNotification = new CartaNotificationHandler(smsNotification);
		
		Request pedido = new Request("sms");
		System.out.println(cartaNotification.escolher(pedido));
	}
}
