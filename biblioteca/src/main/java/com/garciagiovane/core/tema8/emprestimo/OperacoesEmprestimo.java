package com.garciagiovane.core.tema8.emprestimo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import com.garciagiovane.core.tema8.cliente.OperacoesCliente;
import com.garciagiovane.core.tema8.geradorcodigos.GeradorNumerico;
import com.garciagiovane.core.tema8.livro.OperacoesLivro;

public class OperacoesEmprestimo {	
	private OperacoesLivro ops = new OperacoesLivro();
	private OperacoesCliente opsCliente = new OperacoesCliente();
	private GeradorNumerico gerarCodigo = new GeradorNumerico();
	
	public boolean criarEmprestimo(int codigoLivroParaAlugar, int codigoClienteLocatario) {
		Emprestimo emprestimo = new Emprestimo();
		EmprestimoDAO emprestimoDAO2 = new EmprestimoDAO();
		
		List<String> erros = new ArrayList<>();
		
		if (ops.buscarLivroPorId(codigoLivroParaAlugar) == null) {
			erros.add("Livro não encontrado");
		}		
		if(opsCliente.buscarClientePorId(codigoClienteLocatario) == null) {
			erros.add("Cliente não encontrado");
		} else {
			if(opsCliente.buscarClientePorId(codigoClienteLocatario).getLivrosEmprestados() >= 5) {
				erros.add("Cliente atingiu limite de empréstimos");
			}
		}
		
		if (erros.size() > 0) {
			for(String erro : erros) {
				System.out.println(erro);
			}
			return false;
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DATE, 7);
			
			emprestimo.setDataEmprestimo(new Date());
			emprestimo.setDataPrevista(calendar.getTime());
			emprestimo.setIdLivro(codigoLivroParaAlugar);
			emprestimo.setIdPessoa(codigoClienteLocatario);
			emprestimo.setDiasAtraso(0);
			emprestimo.setCodigoEmprestimo(gerarCodigo.gerarCodigo());
			emprestimo.setStatusEmprestimo(true);
			
			ops.criarEmprestimoLivro(codigoLivroParaAlugar);
			opsCliente.criarEmprestimoCliente(codigoClienteLocatario);
			
			emprestimoDAO2.atualizarListaEmprestimos(emprestimo);
			System.out.println("Livro alugado com sucesso");			
			return true;
		}
	}
	
	public boolean listarEmprestimos() {
		EmprestimoDAO epDAO = new EmprestimoDAO();
		OperacoesLivro opsLivro = new OperacoesLivro();
		OperacoesCliente opsCliente = new OperacoesCliente();
		
		List<Emprestimo> emprestimosEncontrados = epDAO.listarEmprestimos();		
		
		if (emprestimosEncontrados != null) {
			for (Emprestimo emprestimo : emprestimosEncontrados ) {
				if (emprestimo.isStatusEmprestimo()) {
					System.out.println("Livro: " + opsLivro.buscarLivroPorId(emprestimo.getIdLivro()).getTitulo()
					+ "\nAlugado por: " + opsCliente.buscarClientePorId(emprestimo.getIdPessoa()).getNomePessoa());
				}
			}
			return true;
		} else {
			System.out.println("Nenhum empréstimo encontrado");
			return false;
		}
	}
	
	public boolean listarAtrasos() {
		EmprestimoDAO epDAO = new EmprestimoDAO();
		OperacoesCliente opsCliente = new OperacoesCliente();
		
		List<Emprestimo> emprestimosEncontrados = epDAO.listarEmprestimos();
		
		if (emprestimosEncontrados != null) {
			for(Emprestimo emprestimo:emprestimosEncontrados) {
				if (emprestimo.getDiasAtraso() > 0) {
					System.out.println("Dias atraso: " + emprestimo.getDiasAtraso()
					+ "Alugado por: " + opsCliente.buscarClientePorId(emprestimo.getIdPessoa()).getNomePessoa());
				}
			}
			return true;
		} else {
			System.out.println("Nenhum empréstimo encontrado");
			return false;
		}
	}
	
	public boolean devolverLivros(int codigoLivroParaDevolver, int codigoClienteLocatario) {
		EmprestimoDAO epDAO = new EmprestimoDAO();
		Emprestimo epEncontrado = epDAO.buscarEmprestimo(codigoLivroParaDevolver, codigoClienteLocatario);
		
		int op = 0;
		do {		
		float multa = 0;
		if (epEncontrado == null) {
			System.out.println("Não há empréstimo com esses dados!");
			return false;
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.DATE, 7);
			
				int diasAtraso = diasAtraso(codigoLivroParaDevolver, codigoClienteLocatario, new Date());
				if (diasAtraso > 0) {
					multa = diasAtraso * 5;
					epEncontrado.setDiasAtraso(diasAtraso);
				}else {
					epEncontrado.setDiasAtraso(0);
				}
				
				epEncontrado.setDataDevolucao(new Date());		
				epEncontrado.setStatusEmprestimo(false);
				System.out.println(epEncontrado.isStatusEmprestimo());
						
				ops.devolverLivro(codigoLivroParaDevolver);
				opsCliente.devolverLivroCliente(codigoClienteLocatario);				
				epDAO.alterarJson(epEncontrado);
				
				System.out.println("Livro devolvido!\nMulta: R$ " + multa);
				op = Integer.parseInt(JOptionPane.showInputDialog("Quer devolver mais livros?"
						+ "\n1 - Sim"
						+ "\n2 - Não"));
				if (op == 1) {
					codigoLivroParaDevolver = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do livro"));
					if (ops.buscarLivroPorId(codigoLivroParaDevolver) == null) {
						System.out.println("Livro não encontrado!\nVerifique o livro");	
						return false;
					}
				}
			}
		}while(op == 1);
		return true;
	}
	
	public int diasAtraso(int codigoLivro, int codigoCliente, Date dataDevolucao) {
		EmprestimoDAO epDAO = new EmprestimoDAO();
		Emprestimo epEncontrado = epDAO.buscarEmprestimo(codigoLivro, codigoCliente);
		
		Date dataPrevistaEntrega = epEncontrado.getDataPrevista();		
		long diferencaDias = dataDevolucao.getTime() - dataPrevistaEntrega.getTime();
		int diasAtraso = (int)TimeUnit.DAYS.convert(diferencaDias, TimeUnit.MILLISECONDS);
		return diasAtraso;
	}
	
	public boolean renovarAluguel(int codigoLivroParaDevolver, int codigoClienteLocatario) {
		EmprestimoDAO epDAO = new EmprestimoDAO();
		Emprestimo epEncontrado = new Emprestimo();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 7);
		
		epEncontrado = epDAO.buscarEmprestimo(codigoLivroParaDevolver, codigoClienteLocatario); 
		if(epEncontrado == null) {
			System.out.println("Não há empréstimo com esses dados!");
			return false;
		}else {
			int diasAtraso = diasAtraso(codigoLivroParaDevolver, codigoClienteLocatario, epEncontrado.getDataPrevista()); 
			if (diasAtraso > 0) {
				System.out.println("Renovação não disponível, motivo: Atraso");
				return false;
			}
			epEncontrado.setDataPrevista(calendar.getTime());
			
			epDAO.alterarJson(epEncontrado);
			System.out.println("Aluguel renovado");
			return true;
		}
	}
}
