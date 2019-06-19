package com.garciagiovane.core.tema12;

import org.junit.Assert;
import org.junit.Test;

public class PessoaBuilderTest {

	@Test
	public void testaCriacaoPessoa() {
		Pessoa pessoa = PessoaBuilder.builder()
				.nome("Josiane")
				.dataNascimento(1995, 01 - 1, 28)
				.endereco("Pioneiro", 49, "Alvorada", "RS")
				.get();
		Assert.assertTrue(pessoa.getNome().equals("Josiane"));
	}
	
	@Test
	public void testaRetornoPessoa() {
		Pessoa pessoa = PessoaBuilder.builder()
				.nome("Jucélia")
				.dataNascimento(1983, 12 - 1, 25)
				.endereco("Cantinho da pizz", 80, "Fortaleza", "CE")
				.get();
		Assert.assertTrue(pessoa.getNome().equals("Jucélia"));;
	}
}
