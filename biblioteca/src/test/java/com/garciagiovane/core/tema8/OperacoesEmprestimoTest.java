package com.garciagiovane.core.tema8;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import com.garciagiovane.core.tema8.emprestimo.OperacoesEmprestimo;

public class OperacoesEmprestimoTest {

	@Test
	public void testCriarEmprestimo() {
		OperacoesEmprestimo opsEmprestimo = new OperacoesEmprestimo();
		Assert.assertTrue(opsEmprestimo.criarEmprestimo(1006,105));
	}

	@Test
	public void testListarEmprestimos() {
		OperacoesEmprestimo opsEmprestimo = new OperacoesEmprestimo();
		Assert.assertTrue(opsEmprestimo.listarEmprestimos());
	}

	@Test
	public void testListarAtrasos() {
		OperacoesEmprestimo opsEmprestimo = new OperacoesEmprestimo();
		Assert.assertTrue(opsEmprestimo.listarAtrasos());
	}

	@Test
	public void testDevolverLivros() {
		OperacoesEmprestimo opsEmprestimo = new OperacoesEmprestimo();
		Assert.assertTrue(opsEmprestimo.devolverLivros(1006, 105));
	}

	@Test
	public void testDiasAtraso() {
		OperacoesEmprestimo opsEmprestimo = new OperacoesEmprestimo();
		Assert.assertEquals(-6, opsEmprestimo.diasAtraso(1002, 112, new Date()));
	}

	@Test
	public void testRenovarAluguel() {
		OperacoesEmprestimo opsEmprestimo = new OperacoesEmprestimo();
		Assert.assertEquals(true, opsEmprestimo.renovarAluguel(1002, 114));
	}

}
