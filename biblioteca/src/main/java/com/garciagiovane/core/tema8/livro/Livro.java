package com.garciagiovane.core.tema8.livro;

public class Livro {
	private int idLivro;
	private String autor;
	private String titulo;
	private boolean statusEmprestimo;
	
	public int getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public boolean getStatusEmprestimo() {
		return statusEmprestimo;
	}
	
	public void setStatusEmprestimo(boolean status) {
		this.statusEmprestimo = status;
	}
}
