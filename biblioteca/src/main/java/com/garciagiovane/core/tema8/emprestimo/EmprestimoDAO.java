package com.garciagiovane.core.tema8.emprestimo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class EmprestimoDAO {
	private boolean arquivo;

	public EmprestimoDAO() {
		File arquivoJson = new File("emprestimos.json");
		arquivo = arquivoJson.exists();
	}

	public List<Emprestimo> listarEmprestimos() {
		if (arquivo) {
			try (BufferedReader reader = new BufferedReader(new FileReader("emprestimos.json"))) {
				Gson gson = new Gson();
				List<Emprestimo> emprestimosEncontradas = gson.fromJson(reader, new TypeToken<List<Emprestimo>>() {
				}.getType());
				return emprestimosEncontradas;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return new ArrayList<Emprestimo>();		
	}
	
	public Emprestimo buscarEmprestimo(int codigoLivro, int codigoCliente) {
		List<Emprestimo> emprestimosEncontrados = listarEmprestimos();		
		for (Emprestimo emprestimo : emprestimosEncontrados) {
			if (emprestimo.getIdLivro() == codigoLivro && emprestimo.getIdPessoa() == codigoCliente) {
				return emprestimo;
			}
		}
		return null; 
	}

	public boolean atualizarListaEmprestimos(Emprestimo emprestimo) {
		List<Emprestimo> novaLista = listarEmprestimos();
		novaLista.add(emprestimo);
		escreverJson(novaLista);
		return true;
	}
	
	public boolean alterarJson(Emprestimo emprestimo) {
		List<Emprestimo> emprestimosEncontrados = listarEmprestimos();
		for (Emprestimo emprestimoEncontrado : emprestimosEncontrados) {
			if (emprestimoEncontrado.getCodigoEmprestimo() == emprestimo.getCodigoEmprestimo()) {
				emprestimoEncontrado.setDataDevolucao(emprestimo.getDataDevolucao());
				emprestimoEncontrado.setDataPrevista(emprestimo.getDataPrevista());
				emprestimoEncontrado.setStatusEmprestimo(emprestimo.isStatusEmprestimo());
				escreverJson(emprestimosEncontrados);
				return true;
			}
		}
		return false;
	}

	public boolean escreverJson(List<Emprestimo> emprestimos) {
		try (Writer writer = new FileWriter("emprestimos.json")) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(emprestimos, writer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
