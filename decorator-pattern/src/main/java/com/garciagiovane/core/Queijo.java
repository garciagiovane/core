package com.garciagiovane.core;

public class Queijo extends Montagem {
	public Queijo(Pizza pizza) {
		super(pizza);
	}
	
	private String sabor() {
		return " + queijo extra";
	}
	
	@Override
	public String descricao() {
		return super.descricao() + sabor();
	}
	
	@Override
	public double montar() {
		return super.montar() + 3;
	}
}
