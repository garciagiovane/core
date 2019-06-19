package com.garciagiovane.core.tema8;

import org.junit.Assert;
import org.junit.Test;

import com.garciagiovane.core.tema8.livro.OperacoesLivro;

public class OperacoesLivroTest {

	@Test
	public void testCadastrarLivro() {
		OperacoesLivro opsLivro = new OperacoesLivro();
		Assert.assertTrue(opsLivro.cadastrarLivro("As branquelas", "Rapunzel"));
	}

	@Test
	public void testExcluirLivro() {
		OperacoesLivro opsLivro = new OperacoesLivro();
		Assert.assertTrue(opsLivro.excluirLivro(1001));
	}

	@Test
	public void testListarLivros() {
		OperacoesLivro opsLivro = new OperacoesLivro();
		Assert.assertTrue(opsLivro.listarLivros());
	}

	@Test
	public void testBuscarLivroPorId() {
		OperacoesLivro opsLivro = new OperacoesLivro();
		Assert.assertEquals("vida sobre rodas",opsLivro.buscarLivroPorId(1002).getTitulo());
	}

	@Test
	public void testBuscarLivroPorAutor() {
		OperacoesLivro opsLivro = new OperacoesLivro();
		Assert.assertTrue(opsLivro.buscarLivroPorAutor("Rapunzel"));
	}

	@Test
	public void testBuscarLivroPorTitulo() {
		OperacoesLivro opsLivro = new OperacoesLivro();
		Assert.assertTrue(opsLivro.buscarLivroPorTitulo("vida sobre rodas"));
	}

	@Test
	public void testCriarEmprestimoLivro() {
		OperacoesLivro opsLivro = new OperacoesLivro();
		Assert.assertTrue(opsLivro.criarEmprestimoLivro(1002));
	}

	@Test
	public void testDevolverLivro() {
		OperacoesLivro opsLivro = new OperacoesLivro();
		Assert.assertTrue(opsLivro.devolverLivro(1002));
	}

}
