package com.garciagiovane.core.tema11;
import org.junit.Assert;
import org.junit.Test;

public class FactoryProdutoLaticinioTest {

	@Test
	public void testGetProdutoLaticinio() {
		FactoryProdutoLaticinio factoryProdutoLaticinio = new FactoryProdutoLaticinio();
		Assert.assertEquals("Queijo", factoryProdutoLaticinio.getProdutoLaticinio("Queijo").getNome());
	}
	
	@Test
	public void testGetProdutoLaticinioSorvete() {
		FactoryProdutoLaticinio factoryProdutoLaticinio = new FactoryProdutoLaticinio();
		Assert.assertEquals("Sorvete", factoryProdutoLaticinio.getProdutoLaticinio("Sorvete").getNome());
	}
}
