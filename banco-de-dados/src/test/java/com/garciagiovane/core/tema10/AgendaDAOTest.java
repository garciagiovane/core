package com.garciagiovane.core.tema10;

import org.junit.Assert;
import org.junit.Test;

public class AgendaDAOTest {
	
	@Test
	public void testCadastro() {
		AgendaDAO agendaDAO = new AgendaDAO();
		Contato contato = new Contato();
		
		contato.setNome("Marcelo");
		contato.setTelefone("(51) 52149-8569");
		contato.setEmail("marcelo09@gmail.com");
		
		Assert.assertTrue(agendaDAO.cadastrarContato(contato));
	}
	
	@Test
	public void testRemoverContato() {
		AgendaDAO agendaDAO = new AgendaDAO();
		Assert.assertTrue(agendaDAO.removerContato(2));
	}
	
	@Test
	public void testListarContatos() {
		AgendaDAO agendaDAO = new AgendaDAO();
		Assert.assertNotNull(agendaDAO.listarContatos());
	}
	
	@Test
	public void testBuscarContatosPorNome() {
		AgendaDAO agendaDAO = new AgendaDAO();
		String parametro = "nome = 'giovane'";
		Assert.assertNotNull(agendaDAO.buscarContatosPorParametro(parametro));	
	}
	
	@Test
	public void testBuscarContatosPorCodigo() {
		AgendaDAO agendaDAO = new AgendaDAO();
		String parametro = "idContato = '5'";
		Assert.assertNotNull(agendaDAO.buscarContatosPorParametro(parametro));	
	}
	
	@Test
	public void testListaOrdenada() {
		AgendaDAO agendaDAO = new AgendaDAO();
		String ordenacao = "ORDER BY nome";
		Assert.assertNotNull(agendaDAO.listaOrdenada(ordenacao));
	}
}
