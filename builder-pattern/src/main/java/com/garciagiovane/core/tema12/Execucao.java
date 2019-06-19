package com.garciagiovane.core.tema12;

public class Execucao {
	public static void main(String[] args) {
		Pessoa pessoa = PessoaBuilder.builder()
				.nome("Giovane")
				.dataNascimento(1996,1,02)
				.endereco("Pioneiro", 49, "Alvorada", "RS")
				.get();
		
		System.out.println(pessoa);
	}
}
