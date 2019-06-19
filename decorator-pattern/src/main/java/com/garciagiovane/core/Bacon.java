package com.garciagiovane.core;

public class Bacon extends Montagem {
	public Bacon(Pizza pizza) {
		super(pizza);
	}
	
	private String sabor() {
		return " + bacon extra";
	}
	
	@Override
	public String descricao() {
		return super.descricao() + sabor();
	}
	
	@Override
	public double montar() {
		return super.montar() + 3.5;
	}
}
