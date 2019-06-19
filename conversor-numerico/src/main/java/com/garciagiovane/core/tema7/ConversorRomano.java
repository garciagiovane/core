package com.garciagiovane.core.tema7;

import java.util.HashMap;
import java.util.Map;

public class ConversorRomano {
	private Map<Character, Integer> valorDaLetra = new HashMap<Character, Integer>();
	
	public ConversorRomano() {
		valorDaLetra.put('I', 1);
		valorDaLetra.put('V', 5);
		valorDaLetra.put('X', 10);
	}
	
	public int converterParaInteiro(String numeroRomano) {
		int resposta = 0;
		
		for (int i = 0; i < numeroRomano.length(); i++) {
			int posicaoAtual = valorDaLetra.get(numeroRomano.charAt(i));
			int proximaPosicao;

			if (i + 1 < numeroRomano.length()) {
				proximaPosicao = valorDaLetra.get(numeroRomano.charAt(i + 1));
	
				if (posicaoAtual >= proximaPosicao) {
					resposta = resposta + posicaoAtual;
				} else {
					resposta = resposta + (proximaPosicao - posicaoAtual);
					i++;
				}
			} else {
				resposta = resposta + posicaoAtual;
				i++;
			}
		}
		return resposta;
	}

}
