package com.garciagiovane.core.tema8.cliente;

public class Pessoa {
	private String nomePessoa;
	private int livrosEmprestados;
	private int idPessoa;
	private int historicoLivrosJaLocados;
	
	public int getHistoricoLivrosJaLocados() {
		return historicoLivrosJaLocados;
	}

	public void setHistoricoLivrosJaLocados(int historicoLivrosJaLocados) {
		this.historicoLivrosJaLocados = historicoLivrosJaLocados;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}
	
	public void setNomePessoa(String pessoa) {
		this.nomePessoa = pessoa;
	}
	
	public int getLivrosEmprestados() {
		return livrosEmprestados;
	}
	
	public void setLivrosEmprestados(int quantidadeLivros) {
		this.livrosEmprestados = quantidadeLivros;
	}
	
	public int getIdPessoa() {
		return idPessoa;
	}
	
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Override
	public String toString() {
		return "Pessoa [nomePessoa=" + nomePessoa + ", livrosEmprestados=" + livrosEmprestados + ", idPessoa="
				+ idPessoa + ", historicoLivrosJaLocados=" + historicoLivrosJaLocados + "]";
	}
	
	
}
