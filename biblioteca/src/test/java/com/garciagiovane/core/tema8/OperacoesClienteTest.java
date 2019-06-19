package com.garciagiovane.core.tema8;

import org.junit.Assert;
import org.junit.Test;
import com.garciagiovane.core.tema8.cliente.OperacoesCliente;
import com.garciagiovane.core.tema8.cliente.Pessoa;
import com.garciagiovane.core.tema8.geradorcodigos.GeradorNumerico;

public class OperacoesClienteTest {

	@Test
	public void testCadastrarCliente() {
		Pessoa cliente = new Pessoa();
		OperacoesCliente opsCliente = new OperacoesCliente();
		GeradorNumerico gerarCodigoCliente = new GeradorNumerico();

		cliente.setIdPessoa(gerarCodigoCliente.gerarCodigoCliente());
		cliente.setNomePessoa("Micaela");
		cliente.setLivrosEmprestados(0);
		cliente.setHistoricoLivrosJaLocados(0);

		Assert.assertTrue(opsCliente.cadastrarCliente(cliente));
	}

	@Test
	public void testBuscarClientePorId() {
		OperacoesCliente opsCliente = new OperacoesCliente();
		Assert.assertEquals("miranda", opsCliente.buscarClientePorId(117).getNomePessoa());
	}

	@Test
	public void testCriarEmprestimoCliente() {
		OperacoesCliente opscCliente = new OperacoesCliente();
		Assert.assertTrue(opscCliente.criarEmprestimoCliente(117));
	}

	@Test
	public void testDevolverLivroCliente() {
		OperacoesCliente opscCliente = new OperacoesCliente();
		Assert.assertTrue(opscCliente.devolverLivroCliente(117));
	}

	@Test
	public void testMostrarMaioresLocadores() {
		OperacoesCliente opscCliente = new OperacoesCliente();
		Assert.assertTrue(opscCliente.mostrarMaioresLocadores());
	}

}
