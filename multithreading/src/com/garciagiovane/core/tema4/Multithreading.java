package com.garciagiovane.core.tema4;
public class Multithreading {
	public static void main(String[] args) {	
		ThreadPar mostraPar = new ThreadPar();
		ThreadImpar mostraImpar = new ThreadImpar();
		
		Thread executaThreadPar = new Thread(mostraPar);
		Thread executaThreadImpar = new Thread(mostraImpar);
		
		executaThreadPar.start();
		executaThreadImpar.start();
	}
}