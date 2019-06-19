package com.garciagiovane.core.tema5;

import com.garciagiovane.core.tema5.lampada.Lampada;

public class Interruptor {
	private Lampada lampada;
	private boolean statusLampada;
	
	public Interruptor(Lampada lampada) {
		this.lampada = lampada;
		lampada.desliga();		
		this.statusLampada = false;
	}
	
	public boolean trocarStatusLampada() {
		if (this.statusLampada == false) {
			lampada.liga();
			this.statusLampada = true;
		} else {
			lampada.desliga();
			this.statusLampada = false;
		}
		return this.statusLampada;
	}
}
