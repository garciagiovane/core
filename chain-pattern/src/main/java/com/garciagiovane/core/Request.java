package com.garciagiovane.core;

public class Request {
	private String tipo;
	
	public Request(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
