package com.garciagiovane.core.tema8;
import javax.swing.JOptionPane;
import com.garciagiovane.core.tema8.cliente.OperacoesCliente;
import com.garciagiovane.core.tema8.cliente.Pessoa;
import com.garciagiovane.core.tema8.emprestimo.OperacoesEmprestimo;
import com.garciagiovane.core.tema8.geradorcodigos.GeradorNumerico;
import com.garciagiovane.core.tema8.livro.OperacoesLivro;

public class Aplicacao {
	public static void main(String[] args) {
		OperacoesLivro ops = new OperacoesLivro();
		OperacoesCliente opsCliente = new OperacoesCliente();
		OperacoesEmprestimo opsEmprestimo = new OperacoesEmprestimo();
		int op;

		do {
			op = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção desejada" + "\n1 - Cadastrar Livros"
					+ "\n2 - Listar Livros" + "\n3 - Excluir livro" + "\n4 - Buscar livro por autor"
					+ "\n5 - Buscar livro por título" + "\n6 - Cadastrar cliente" + "\n7 - Fazer empréstimos"
					+ "\n8 - Devolver livros" + "\n9 - Renovar aluguel" + "\n10 - Livros Alugados"
					+ "\n11 - Top 10 locadores" + "\n12 - Listar atrasos" + "\n0 - Sair"));
			switch (op) {
			case 1:
				String nomeLivro = JOptionPane.showInputDialog("Digite o nome do livro");
				String autor = JOptionPane.showInputDialog("Digite o autor do livro");
				ops.cadastrarLivro(nomeLivro, autor);
				break;
			case 2:
				ops.listarLivros();
				break;
			case 3:
				int codigoParaExclusao = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do livro"));
				ops.excluirLivro(codigoParaExclusao);
				break;
			case 4:
				String autorPesquisa = JOptionPane.showInputDialog("Digite o autor");
				ops.buscarLivroPorAutor(autorPesquisa);
				break;
			case 5:
				String titulo = JOptionPane.showInputDialog("Digite o título");
				ops.buscarLivroPorTitulo(titulo);
			case 6:
				GeradorNumerico gerarCodigo = new GeradorNumerico();
				Pessoa cliente = new Pessoa();

				cliente.setIdPessoa(gerarCodigo.gerarCodigoCliente());
				cliente.setNomePessoa(JOptionPane.showInputDialog("Digite o nome do cliente"));
				cliente.setLivrosEmprestados(0);
				cliente.setHistoricoLivrosJaLocados(0);

				opsCliente.cadastrarCliente(cliente);
				break;
			case 7:
				int codigoLivroParaAlugar = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o código do livro para alugar"));
				int codigoCliente = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cliente"));
				opsEmprestimo.criarEmprestimo(codigoLivroParaAlugar, codigoCliente);
				break;
			case 8:
				int codigoLivroParaDevolver = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o código do livro para devolver"));
				int codigoClienteLocatario = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o código do cliente"));

				opsEmprestimo.devolverLivros(codigoLivroParaDevolver, codigoClienteLocatario);
				break;
			case 9:
				int codigoLivroRenovacaoAluguel = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o código do livro"));
				int codigoClienteRenovacaoAluguel = Integer
						.parseInt(JOptionPane.showInputDialog("Digite o código do cliente"));
				opsEmprestimo.renovarAluguel(codigoLivroRenovacaoAluguel, codigoClienteRenovacaoAluguel);
				break;
			case 10:
				opsEmprestimo.listarEmprestimos();
				break;
			case 11:
				opsCliente.mostrarMaioresLocadores();
				break;
			case 12:
				opsEmprestimo.listarAtrasos();
				break;
			case 0:
				System.exit(1);
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}

		} while (op != 0);
	}
}
