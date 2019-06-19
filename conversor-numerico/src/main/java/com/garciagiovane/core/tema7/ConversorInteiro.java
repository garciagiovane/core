package com.garciagiovane.core.tema7;

import java.util.HashMap;
import java.util.Map;

public class ConversorInteiro {
	Map<Integer, String> numerosRomanos = new HashMap<Integer, String>();
	
	public ConversorInteiro() {
		numerosRomanos.put(1, "I");
		numerosRomanos.put(4, "IV");
		numerosRomanos.put(5, "V");
		numerosRomanos.put(9, "IX");
		numerosRomanos.put(10, "X");
	}

	public String converterParaRomano(int numeroInteiro) {
		String numeroConvertido = "";
		int numeroParaComparacao[] = {10, 9, 5, 4, 1};
		int  i = 0;
		
		while (numeroInteiro > 0) {			
			if (numeroInteiro >= numeroParaComparacao[i]) {
				numeroConvertido += numerosRomanos.get(numeroParaComparacao[i]);
				numeroInteiro -= numeroParaComparacao[i];
			} else {
				i++;
			}
		}		
		return numeroConvertido;
	}
}
