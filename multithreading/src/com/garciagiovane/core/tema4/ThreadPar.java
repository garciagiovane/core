package com.garciagiovane.core.tema4;

public class ThreadPar implements Runnable {
	@Override
	public void run() {
		GeradorNumerico geradorNumerico = new GeradorNumerico();
		
		try {
			for (int i = 0; i >= 0; i++) {
				System.out.println("Número Par: " + geradorNumerico.gerarPar());
				Thread.sleep(500);
			}
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}
}
