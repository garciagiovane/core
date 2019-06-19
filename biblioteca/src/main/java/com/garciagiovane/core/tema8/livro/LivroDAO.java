package com.garciagiovane.core.tema8.livro;

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

public class LivroDAO {	
	private boolean arquivo;

	public LivroDAO() {
		File arquivoJson = new File("livros.json");
		arquivo = arquivoJson.exists();
	}
	
	public List<Livro> listarLivros(){
		if (arquivo) {
			try (BufferedReader reader = new BufferedReader(new FileReader("livros.json"))) {
				Gson gson = new Gson();				
				List<Livro> livrosEncontradas = gson.fromJson(reader, new TypeToken<List<Livro>>() {
				}.getType());				
				return livrosEncontradas;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return new ArrayList<Livro>();
	}
	
	public boolean acrescentarLivro(Livro livro) {
		List<Livro> novaLista = listarLivros();
		novaLista.add(livro);
		escreverJson(novaLista);
		return true;
	}
	
	public boolean escreverJson(List<Livro> livros) {
		try (Writer writer = new FileWriter("livros.json")) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(livros, writer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
}
