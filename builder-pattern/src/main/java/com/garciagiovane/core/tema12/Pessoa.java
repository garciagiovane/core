package com.garciagiovane.core.tema12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
	private String nome;
	private Date dataNascimento;
	private Endereco endereco;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		String formatoData = "dd-MM-yyy";
		SimpleDateFormat formatarData = new SimpleDateFormat(formatoData);
		
		return "Nome: " + this.getNome()
		+ "\nData Nascimento: " +  formatarData.format(this.getDataNascimento())
		+ "\nEndereço: " + this.getEndereco();
	}
}
