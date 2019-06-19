package com.garciagiovane.core.tema7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.garciagiovane.core.tema7.ConversorRomano;

public class ConversaoTest {
	@Test
	public void testarNumeroRomano() {
		ConversorRomano numeroRomano = new ConversorRomano();
		
		assertEquals(15, numeroRomano.converterParaInteiro("XV"));
		assertEquals(1, numeroRomano.converterParaInteiro("I"));
		assertEquals(4, numeroRomano.converterParaInteiro("IV"));
		assertEquals(9, numeroRomano.converterParaInteiro("IX"));
		assertEquals(14, numeroRomano.converterParaInteiro("XIV"));
		assertEquals(19, numeroRomano.converterParaInteiro("XIX"));
		assertEquals(23, numeroRomano.converterParaInteiro("XXIII"));
		assertEquals(5, numeroRomano.converterParaInteiro("V"));
	}
	
	@Test
	public void testarNumeroInteiro() {
		ConversorInteiro numeroInteiro = new ConversorInteiro();
		
		assertEquals("XVII", numeroInteiro.converterParaRomano(17));
		assertEquals("IX", numeroInteiro.converterParaRomano(9));
		assertEquals("IV", numeroInteiro.converterParaRomano(4));
		assertEquals("XIX", numeroInteiro.converterParaRomano(19));
		assertEquals("XIV", numeroInteiro.converterParaRomano(14));
		assertEquals("I", numeroInteiro.converterParaRomano(1));
		assertEquals("XXIII", numeroInteiro.converterParaRomano(23));
	}
}
