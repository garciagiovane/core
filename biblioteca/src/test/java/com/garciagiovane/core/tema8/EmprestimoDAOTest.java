package com.garciagiovane.core.tema8;

import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.garciagiovane.core.tema8.emprestimo.Emprestimo;
import com.garciagiovane.core.tema8.emprestimo.EmprestimoDAO;
import com.garciagiovane.core.tema8.geradorcodigos.GeradorNumerico;

public class EmprestimoDAOTest {

	@Test
	public void atualizarListaEmprestimos() {
		EmprestimoDAO epDAO = new EmprestimoDAO();
		Emprestimo emprestimo = new Emprestimo();
		GeradorNumerico gerarCodigoEmprestimo = new GeradorNumerico();
		
		emprestimo.setCodigoEmprestimo(gerarCodigoEmprestimo.gerarCodigo());
		emprestimo.setDataDevolucao(new Date());
		emprestimo.setDataEmprestimo(new Date());
		emprestimo.setDataPrevista(new Date());
		emprestimo.setDiasAtraso(0);
		emprestimo.setIdLivro(1004);
		emprestimo.setIdPessoa(103);
		emprestimo.setStatusEmprestimo(true);
		
		Assert.assertTrue(epDAO.atualizarListaEmprestimos(emprestimo));
	}

	@Test
	public void testListarEmprestimos() {
		EmprestimoDAO epDAO2 = new EmprestimoDAO();
		Assert.assertTrue(epDAO2.listarEmprestimos().isEmpty());
	}

	@Test
	public void testEscreverJson() {
		EmprestimoDAO epDAO = new EmprestimoDAO();
		List<Emprestimo> epsEncontrados = epDAO.listarEmprestimos();		
		
		Assert.assertTrue(epDAO.escreverJson(epsEncontrados));
	}

	@Test
	public void alterarJson() {
		EmprestimoDAO epDAO = new EmprestimoDAO();
		Emprestimo emprestimo = new Emprestimo();
		
		emprestimo.setCodigoEmprestimo(2);
		emprestimo.setDataDevolucao(new Date());
		emprestimo.setDataEmprestimo(new Date());
		emprestimo.setDataPrevista(new Date());
		emprestimo.setDiasAtraso(0);
		emprestimo.setIdLivro(1004);
		emprestimo.setIdPessoa(103);
		emprestimo.setStatusEmprestimo(false);
		
		Assert.assertTrue(epDAO.alterarJson(emprestimo));		
	}

	@Test
	public void testBuscarEmprestimo() {
		EmprestimoDAO epDAO = new EmprestimoDAO();		
		Assert.assertNotNull(epDAO.buscarEmprestimo(1000, 114));
	}

}
