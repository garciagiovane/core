package com.garciagiovane.core;

public abstract class Montagem implements Pizza{
	private Pizza pizza;
	
	public Montagem(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String descricao() {
		return pizza.descricao();
	}
	
	@Override
	public double montar() {
		return pizza.montar();
	}
}
