package com.garciagiovane.core.tema8;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.garciagiovane.core.tema8.cliente.ClienteDAO;
import com.garciagiovane.core.tema8.cliente.Pessoa;
import com.garciagiovane.core.tema8.geradorcodigos.GeradorNumerico;

public class ClienteDAOTest {

	@Test
	public void testCadastrarCliente() {
		Pessoa cliente = new Pessoa();
		ClienteDAO clienteDAO = new ClienteDAO();
		GeradorNumerico gerarCodigoCliente = new GeradorNumerico();

		cliente.setIdPessoa(gerarCodigoCliente.gerarCodigoCliente());
		cliente.setNomePessoa("Micaela");
		cliente.setLivrosEmprestados(0);
		cliente.setHistoricoLivrosJaLocados(0);

		Assert.assertTrue(clienteDAO.atualizarListaClientes(cliente));
	}

	@Test
	public void testListarClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Assert.assertNotNull(clienteDAO.listarClientes());
	}

	@Test
	public void testAlterarCadastroCliente() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Pessoa> clientesEncontrados = clienteDAO.listarClientes();
		
		Assert.assertTrue(clienteDAO.escreverJson(clientesEncontrados));
	}

}
