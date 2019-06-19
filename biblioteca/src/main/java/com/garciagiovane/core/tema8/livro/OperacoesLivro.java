package com.garciagiovane.core.tema8.livro;

import java.util.List;

import com.garciagiovane.core.tema8.geradorcodigos.GeradorNumerico;

public class OperacoesLivro {
	public boolean cadastrarLivro(String nomeLivro, String autor) {
		Livro livro = new Livro();
		LivroDAO livroDAO2 = new LivroDAO();
		GeradorNumerico geradorCodigo = new GeradorNumerico();
		livro.setIdLivro(geradorCodigo.gerarCodigoLivro());
		livro.setTitulo(nomeLivro);
		livro.setAutor(autor);
		livro.setStatusEmprestimo(false);
		boolean resposta = livroDAO2.acrescentarLivro(livro);
		if (resposta) {
			System.out.println("Livro cadastrado!");
			return true;
		}
		return false;
	}

	public boolean excluirLivro(int codParaExclusao) {
		boolean resposta = false;
		LivroDAO livroDAO2 = new LivroDAO();
		List<Livro> livrosEncontrados = livroDAO2.listarLivros();

		if (livrosEncontrados.size() > 0) {
			for (Livro livro : livrosEncontrados) {
				if (livro.getIdLivro() == codParaExclusao) {
					livrosEncontrados.remove(livro);
					resposta = livroDAO2.escreverJson(livrosEncontrados);
				}
			}
			if (!resposta) {
				System.out.println("Livro não pode ser excluído");
			}
		} else {
			System.out.println("Não há livros para excluir");
		}
		return resposta;
	}

	public boolean listarLivros() {
		LivroDAO livroDAO2 = new LivroDAO();
		List<Livro> livrosEncontrados = livroDAO2.listarLivros();

		if (livrosEncontrados != null) {
			for (Livro lvs : livrosEncontrados) {
				System.out.print("Código Livro: " + lvs.getIdLivro() + 
						"\nTítulo: " + lvs.getTitulo() 
						+ "\nAutor: " + lvs.getAutor());
				if (lvs.getStatusEmprestimo()) {
					System.out.print("\nEstá emprestado? sim\n\n");
				} else {
					System.out.print("\nEstá emprestado? não\n\n");
				}
			}
			return true;
		} else {
			System.out.println("Nenhum livro encontrado");
			return false;
		}
	}

	public Livro buscarLivroPorId(int idLivro) {
		LivroDAO livroDAO2 = new LivroDAO();
		List<Livro> livrosEncontrados = livroDAO2.listarLivros();
		
		if (!livrosEncontrados.isEmpty()) {
			for (Livro livro : livrosEncontrados) {
				if (livro.getIdLivro() == idLivro) {
					return livro;
				}
			}
		}
		System.out.println("Nenhum livro encontrado!");
		return null;
	}

	public boolean buscarLivroPorAutor(String autor) {
		LivroDAO livroDAO2 = new LivroDAO();
		List<Livro> livrosEncontrados = livroDAO2.listarLivros();

		if (!livrosEncontrados.isEmpty()) {
			for (Livro livro : livrosEncontrados) {
				if (livro.getAutor().equals(autor)) {
					System.out.println("Código: " + livro.getIdLivro() + "\nTítulo: " + livro.getTitulo() + "\nAutor: "
							+ livro.getAutor() + "\nEstá emprestado? " + livro.getStatusEmprestimo());
				}
			}
			return true;
		}
		System.out.println("Nenhum livro encontrado!");
		return false;
	}

	public boolean buscarLivroPorTitulo(String titulo) {
		LivroDAO livroDAO2 = new LivroDAO();
		List<Livro> livrosEncontrados = livroDAO2.listarLivros();

		if (!livrosEncontrados.isEmpty()) {
			for (Livro livro : livrosEncontrados) {
				if (livro.getTitulo().equals(titulo)) {
					System.out.println("Código: " + livro.getIdLivro() + "\nTítulo: " + livro.getTitulo() + "\nAutor: "
							+ livro.getAutor() + "\nEstá emprestado? " + livro.getStatusEmprestimo());
				}
			}
			return true;
		} else {
			System.out.println("Nenhum livro encontrado!");
			return false;
		}
	}

	public boolean criarEmprestimoLivro(int codigoLivro) {
		LivroDAO livroDAO2 = new LivroDAO();
		List<Livro> livrosEncontrados = livroDAO2.listarLivros();

		for (Livro livro : livrosEncontrados) {
			if (livro.getIdLivro() == codigoLivro && !livro.getStatusEmprestimo()) {
				livro.setStatusEmprestimo(true);
				livroDAO2.escreverJson(livrosEncontrados);
				return true;
			}
		}
		return false;
	}

	public boolean devolverLivro(int codigoLivro) {
		LivroDAO livroDAO2 = new LivroDAO();
		List<Livro> livrosEncontrados = livroDAO2.listarLivros();

		for (Livro livro : livrosEncontrados) {
			if (livro.getIdLivro() == codigoLivro && livro.getStatusEmprestimo()) {
				livro.setStatusEmprestimo(false);
				livroDAO2.escreverJson(livrosEncontrados);
				return true;
			}
		}
		return false;
	}
}
