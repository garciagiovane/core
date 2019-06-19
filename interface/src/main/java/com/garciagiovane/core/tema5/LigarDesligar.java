package com.garciagiovane.core.tema5;

import com.garciagiovane.core.tema5.lampada.Lampada;
import com.garciagiovane.core.tema5.lampada.LampadaQuarto;
import com.garciagiovane.core.tema5.lampada.LampadaSala;

public class LigarDesligar {
	public static void main(String[] args) {
		Lampada quarto = new LampadaQuarto();
		Lampada sala = new LampadaSala();
		
		Interruptor interruptorQuarto = new Interruptor(quarto);
		Interruptor interruptorSala = new Interruptor(sala);
		
		interruptorQuarto.trocarStatusLampada();
		interruptorSala.trocarStatusLampada();
	}
}
