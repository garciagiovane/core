package com.garciagiovane.core.tema12;

import java.util.Calendar;

public class PessoaBuilder {
	private Pessoa pessoa;

	public PessoaBuilder() {
		this.pessoa = new Pessoa();
	}
	
	public static PessoaBuilder builder() {
		return new PessoaBuilder();
	}
	
	public PessoaBuilder nome(String nome) {
		this.pessoa.setNome(nome);
		return this;
	}
	
	public PessoaBuilder dataNascimento(int ano, int mes, int dia) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(ano, mes - 1, dia);
			
		this.pessoa.setDataNascimento(calendar.getTime());
		return this;
	}
	
	public PessoaBuilder endereco(String rua, int numero, String cidade, String estado) {
		Endereco endereco = new Endereco();
		endereco.setRua(rua);
		endereco.setNumero(numero);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		this.pessoa.setEndereco(endereco);
		return this;
	}
	
	public Pessoa get() {
		return this.pessoa;
	}

}
