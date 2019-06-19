package com.garciagiovane.core;

import org.junit.Assert;
import org.junit.Test;

public class NotificationHandlerTest {

	@Test
	public void testNotificationHandlerSMS() {
		NotificationHandler smsNotification = new SMSNotificationHandler(null);
		NotificationHandler cartaNotification = new CartaNotificationHandler(smsNotification);
		NotificationHandler emailNotification = new EmailNotificationHandler(cartaNotification);		
		
		Request pedido = new Request("sms");
		Assert.assertEquals("Notificação via SMS", emailNotification.escolher(pedido));
	}
	
	@Test
	public void testNotificationHandlerEmail() {
		NotificationHandler cartaNotification = new CartaNotificationHandler(null);
		NotificationHandler emailNotification = new EmailNotificationHandler(cartaNotification);
		NotificationHandler smsNotification = new SMSNotificationHandler(emailNotification);				
		
		Request pedido = new Request("email");				
		Assert.assertEquals("Notificação via Email", smsNotification.escolher(pedido));
	}
	
	@Test
	public void testNotificationHandlerCarta() {
		NotificationHandler emailNotification = new EmailNotificationHandler(null);
		NotificationHandler smsNotification = new SMSNotificationHandler(emailNotification);
		NotificationHandler cartaNotification = new CartaNotificationHandler(smsNotification);
		
		Request pedido = new Request("carta");
		Assert.assertEquals("Notificação via Carta", cartaNotification.escolher(pedido));
	}

}
