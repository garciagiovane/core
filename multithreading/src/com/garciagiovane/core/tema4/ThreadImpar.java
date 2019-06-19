package com.garciagiovane.core.tema4;

public class ThreadImpar implements Runnable {
	@Override
	public void run() {
		GeradorNumerico geradorNumerico = new GeradorNumerico();
		
		try {		
			for (int i = 0; i >= 0; i++) {
				System.out.println("Número Ímpar: " + geradorNumerico.gerarImpar());
				Thread.sleep(100);
			}			
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}
}
