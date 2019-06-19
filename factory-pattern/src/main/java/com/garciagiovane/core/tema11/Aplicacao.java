package com.garciagiovane.core.tema11;

public class Aplicacao {

	public static void main(String[] args) {
		FactoryProdutoLaticinio factoryProdutosLaticinio = new FactoryProdutoLaticinio();
		factoryProdutosLaticinio.getProdutoLaticinio("Sorvete");
		factoryProdutosLaticinio.getProdutoLaticinio("Queijo");
		
	}
}
