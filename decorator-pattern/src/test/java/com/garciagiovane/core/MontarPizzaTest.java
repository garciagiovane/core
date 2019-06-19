package com.garciagiovane.core;

import org.junit.Assert;
import org.junit.Test;

public class MontarPizzaTest {

	@Test
	public void testMontarPizzaComQueijo() {
		Pizza comQueijo = new Queijo(new PizzaPronta());
		Assert.assertEquals(23, comQueijo.montar(), 0);
	}
	
	@Test
	public void testMontarPizzaComBacon() {
		Pizza comBacon = new Bacon(new PizzaPronta());
		Assert.assertEquals(23.5, comBacon.montar(), 0);
	}
	
	@Test
	public void testMontarPizzaComBaconEQueijo() {
		Pizza comBaconEQueijo = new Bacon(new Queijo(new PizzaPronta()));
		Assert.assertEquals(26.5, comBaconEQueijo.montar(), 0);
	}
}
