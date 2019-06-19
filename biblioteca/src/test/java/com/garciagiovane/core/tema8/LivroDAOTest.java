package com.garciagiovane.core.tema8;

import org.junit.Assert;
import org.junit.Test;
import com.garciagiovane.core.tema8.geradorcodigos.GeradorNumerico;
import com.garciagiovane.core.tema8.livro.Livro;
import com.garciagiovane.core.tema8.livro.LivroDAO;

public class LivroDAOTest {

	@Test
	public void testCadastrarLivroDAO() {
		LivroDAO livroDAO = new LivroDAO();
		Livro livro = new Livro();
		GeradorNumerico gerarCodigoLivro = new GeradorNumerico();
		
		livro.setIdLivro(gerarCodigoLivro.gerarCodigoLivro());
		livro.setTitulo("Uma história muito louca");
		livro.setAutor("Augusto");
		livro.setStatusEmprestimo(false);
		
		Assert.assertTrue(livroDAO.acrescentarLivro(livro));
		
	}

	@Test
	public void testListarLivros() {
		LivroDAO livroDAO = new LivroDAO();
		Assert.assertNotNull(livroDAO.listarLivros());		
	}

	@Test
	public void testAlteraStatusLivro() {
		LivroDAO livroDAO = new LivroDAO();		
		Assert.assertTrue(livroDAO.escreverJson(livroDAO.listarLivros()));
	}
}
