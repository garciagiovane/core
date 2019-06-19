package com.garciagiovane.core;

public class PizzaPronta implements Pizza{
	private double preco = 20;
	
	@Override
	public String descricao() {
		return "Pizza";
	}
	 
	@Override
	public double montar() {
		return preco;
	}
}
