package com.garciagiovane.core.tema8.geradorcodigos;

import java.util.Comparator;
import java.util.List;
import com.garciagiovane.core.tema8.cliente.ClienteDAO;
import com.garciagiovane.core.tema8.cliente.Pessoa;
import com.garciagiovane.core.tema8.emprestimo.Emprestimo;
import com.garciagiovane.core.tema8.emprestimo.EmprestimoDAO;
import com.garciagiovane.core.tema8.livro.Livro;
import com.garciagiovane.core.tema8.livro.LivroDAO;

public class GeradorNumerico {
	private static int codigoGerado;
	
	public int gerarCodigo() {
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> epsEncontrados = emprestimoDAO.listarEmprestimos();
		if (epsEncontrados.isEmpty()) {
			return 1;
		}
		Emprestimo emprestimoComMaiorCodigo = epsEncontrados.stream().max(Comparator.comparing(Emprestimo::getCodigoEmprestimo)).get();
		codigoGerado = emprestimoComMaiorCodigo.getCodigoEmprestimo();
		return codigoGerado + 1;
	}
	
	public int gerarCodigoCliente() {
		ClienteDAO clienteDAO2 = new ClienteDAO();
		List<Pessoa> clientesEncontrados = clienteDAO2.listarClientes();
		if (clientesEncontrados.isEmpty()) {
			return 1;
		}
		Pessoa pessoaComMaiorCodigo = clientesEncontrados.stream().max(Comparator.comparing(Pessoa::getIdPessoa)).get();
		codigoGerado = pessoaComMaiorCodigo.getIdPessoa();
		
		return codigoGerado + 1;
	}
	
	public int gerarCodigoLivro() {
		LivroDAO livroDAO2 = new LivroDAO();
		List<Livro> livrosEncontrados = livroDAO2.listarLivros();		
		if (livrosEncontrados.isEmpty()) {
			return 1;
		}		
		Livro livroComMaiorCodigo = livrosEncontrados.stream().max(Comparator.comparing(Livro::getIdLivro)).get();
		codigoGerado = livroComMaiorCodigo.getIdLivro();		
		return codigoGerado + 1;
	}
	
	public int gerarHistoricoAluguel(int codigoCliente) {
		int qtdLivrosJaAlugados = 0;
		ClienteDAO clienteDAO2 = new ClienteDAO();
		List<Pessoa> clientesEncontrados = clienteDAO2.listarClientes();
		
		for (Pessoa pessoa : clientesEncontrados) {
			if (pessoa.getIdPessoa() == codigoCliente) {
				qtdLivrosJaAlugados = pessoa.getHistoricoLivrosJaLocados();
			}
		}
		return qtdLivrosJaAlugados + 1;		
	}
}
