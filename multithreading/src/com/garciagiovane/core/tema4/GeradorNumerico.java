package com.garciagiovane.core.tema4;
import java.util.Random;

public class GeradorNumerico {
	public int gerarPar() {
		Random rand = new Random();
		int numeroGerado = rand.nextInt(99);
		
		if(numeroGerado % 2 != 0 ) {
			numeroGerado = numeroGerado + 1;
		}
		return numeroGerado;
	}
	
	public int gerarImpar() {
		Random rand = new Random();
		int numeroGerado = rand.nextInt(99);
		
		if(numeroGerado % 2 == 0) {
			numeroGerado = numeroGerado + 1;
		}		
		return numeroGerado;
	}
}