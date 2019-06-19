package com.garciagiovane.core.tema11;

public class Queijo extends ProdutoLaticinio {

	public Queijo(String nome) {
		setNome(nome);
		System.out.println("Este " + getNome() + " é um objeto da classe Queijo");
	}
}
