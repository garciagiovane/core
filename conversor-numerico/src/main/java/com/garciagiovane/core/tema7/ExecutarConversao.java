package com.garciagiovane.core.tema7;

import javax.swing.JOptionPane;

public class ExecutarConversao {

	public static void main(String[] args) {
		ConversorInteiro numeroInteiro = new ConversorInteiro();
		ConversorRomano numeroRomano = new ConversorRomano();
		int op = 0;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção desejada"
					+ "\n1 - Converter de Inteiro para Romano"
					+ "\n2 - Converter de Romano para Inteiro"
					+ "\n0 - Encerrar"));
			switch (op) {
			case 1:
				int numeroDigitado = Integer.parseInt(JOptionPane.showInputDialog("Digite o número inteiro"));
				
				if(numeroDigitado > 0 && numeroDigitado <= 20)
					JOptionPane.showMessageDialog(null, "Número em Romano: "+numeroInteiro.converterParaRomano(numeroDigitado), "Resposta", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Número precisa ser de 1 e 20", "Resposta", JOptionPane.ERROR_MESSAGE);
				break;
			case 2:
				String numeroRomanoDigitado = JOptionPane.showInputDialog("Digite o número romano").toUpperCase();
				
				int numeroReposta = numeroRomano.converterParaInteiro(numeroRomanoDigitado); 
				if(numeroReposta != 0)
					JOptionPane.showMessageDialog(null, "Número em Romano: "+numeroReposta, "Resposta", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Número precisa ser de 1 e 20", "Resposta", JOptionPane.ERROR_MESSAGE);
				break;

			default:
				break;
			}	
		
		} while(op != 0);		

	}

}
