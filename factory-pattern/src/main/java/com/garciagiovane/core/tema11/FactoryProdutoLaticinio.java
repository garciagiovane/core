package com.garciagiovane.core.tema11;

public class FactoryProdutoLaticinio {
	public ProdutoLaticinio getProdutoLaticinio(String nome) {
		switch (nome) {
		case "Queijo":
			return new Queijo(nome);
		case "Sorvete":
			return new Sorvete(nome);
		default:
			throw new RuntimeException("Objeto inválido");
		}
	}
}
