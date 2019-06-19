package com.garciagiovane.core.cliente.test;
import org.junit.Assert;
import org.junit.Test;

import com.garciagiovane.core.cliente.Cliente;
import com.garciagiovane.core.notificacao.Mensagem;

public class MensagemTest {

	@Test
	public void testCriarMensagemEmail() {
		Assert.assertNotNull(new Mensagem(new Cliente("Giovane", "giovane@mail.com")));
	}
	
	@Test
	public void testCriarMensagemSMS() {
		Assert.assertNotNull(new Mensagem(new Cliente("Giovane", "giovane@mail.com", "969632321")));
	}
}
