package com.garciagiovane.core.tema8.cliente;

import java.util.List;

import com.garciagiovane.core.tema8.geradorcodigos.GeradorNumerico;

public class OperacoesCliente {
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	public boolean cadastrarCliente(Pessoa cliente) {
		boolean resposta = clienteDAO.atualizarListaClientes(cliente);
		if (resposta) {
			System.out.println("Cliente cadastrado!");
			return true;
		}
		return false;
	}
	
	public Pessoa buscarClientePorId(int codigoCliente) {
		List<Pessoa> listaPessoasEncontradas = clienteDAO.listarClientes();		
		Pessoa clienteEncontrado = null;		
		for (Pessoa cliente : listaPessoasEncontradas) {
			if (cliente.getIdPessoa() == codigoCliente) {
				clienteEncontrado = cliente;
			}
		}	
		return clienteEncontrado;
	}
	
	public boolean criarEmprestimoCliente(int codigoCliente) {
		GeradorNumerico geradorNumerico = new GeradorNumerico();
		List<Pessoa> pessoasEncontradas = clienteDAO.listarClientes();
		
		for(Pessoa cliente : pessoasEncontradas) {
			if(cliente.getIdPessoa() == codigoCliente) {
				int livrosJaAlugados = cliente.getLivrosEmprestados();
				cliente.setLivrosEmprestados(livrosJaAlugados + 1);
				cliente.setHistoricoLivrosJaLocados(geradorNumerico.gerarHistoricoAluguel(codigoCliente));
				clienteDAO.escreverJson(pessoasEncontradas);
				return true;
			}
		}		
		return false;
	}	
	
	public boolean devolverLivroCliente(int codigoCliente) {
		List<Pessoa> pessoasEncontradas = clienteDAO.listarClientes();
		
		for(Pessoa cliente : pessoasEncontradas) {
			if (cliente.getIdPessoa() == codigoCliente) {
				int livrosJaAlugados = cliente.getLivrosEmprestados();
				cliente.setLivrosEmprestados(livrosJaAlugados - 1);
				clienteDAO.escreverJson(pessoasEncontradas);
				return true;
			}
		}
		return false;
	}
	
	public boolean mostrarMaioresLocadores() {
		List<Pessoa> clientesEncontrados = clienteDAO.listarClientes();		
		clientesEncontrados.sort((p1, p2) -> p2.getHistoricoLivrosJaLocados() - p1.getHistoricoLivrosJaLocados());
		
		System.out.println("Top 10 clientes");
		for(int i = 0; i < 10; i++) {
			System.out.println("Nome: " + clientesEncontrados.get(i).getNomePessoa());
		}
		return true;
	}
}
