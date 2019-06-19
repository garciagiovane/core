package com.garciagiovane.core.tema12;

public class Endereco {
	private String rua;
	private int numero;
	private String cidade;
	private String estado;
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Rua " + this.getRua()
		+ ", " + this.getNumero()
		+ ", " + this.getCidade()
		+ " - " + this.getEstado();
	}
}
