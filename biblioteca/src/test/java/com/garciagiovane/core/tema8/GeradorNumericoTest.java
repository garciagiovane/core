package com.garciagiovane.core.tema8;

import static org.junit.Assert.*;

import org.junit.Test;

import com.garciagiovane.core.tema8.geradorcodigos.GeradorNumerico;

public class GeradorNumericoTest {
	
	@Test
	public void testGerarCodigo() {
		GeradorNumerico geradorNumerico = new GeradorNumerico();
		assertEquals(15, geradorNumerico.gerarCodigo());
	}

	@Test
	public void testGerarCodigoCliente() {
		GeradorNumerico geradorNumerico = new GeradorNumerico();
		assertEquals(107, geradorNumerico.gerarCodigoCliente());
	}

	@Test
	public void testGerarCodigoLivro() {
		GeradorNumerico geradorNumerico = new GeradorNumerico();
		assertEquals(1001, geradorNumerico.gerarCodigoLivro());
	}

	@Test
	public void testGerarHistoricoAluguel() {
		GeradorNumerico geradorNumerico = new GeradorNumerico();
		assertEquals(1, geradorNumerico.gerarHistoricoAluguel(117));
	}

}
