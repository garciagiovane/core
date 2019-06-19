package com.garciagiovane.core.tema5;

import static org.junit.Assert.*;

import org.junit.Test;

import com.garciagiovane.core.tema5.lampada.Lampada;
import com.garciagiovane.core.tema5.lampada.LampadaQuarto;

public class InterruptorTest {

	@Test
	public void test() {
		Lampada lampada = new LampadaQuarto();
		Interruptor interruptorQuarto = new Interruptor(lampada);
		
		assertFalse(!interruptorQuarto.trocarStatusLampada());	
		assertFalse(interruptorQuarto.trocarStatusLampada()); 
	}

}
