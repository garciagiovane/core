package com.garciagiovane.core.tema11;

public class Sorvete extends ProdutoLaticinio {
	
	public Sorvete(String nome) {
		setNome(nome);
		System.out.println("Este " + getNome() + " é um objeto da classe Sorvete");
	}
}
