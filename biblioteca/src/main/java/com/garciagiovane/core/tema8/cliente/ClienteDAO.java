package com.garciagiovane.core.tema8.cliente;

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

public class ClienteDAO {
	private boolean arquivo;

	public ClienteDAO() {
		File arquivoJson = new File("cliente.json");
		arquivo = arquivoJson.exists();
	}
	
	public List<Pessoa> listarClientes(){
		if (arquivo) {
			try (BufferedReader reader = new BufferedReader(new FileReader("cliente.json"))) {
				Gson gson = new Gson();				
				List<Pessoa> pessoaEncontradas = gson.fromJson(reader, new TypeToken<List<Pessoa>>() {
				}.getType());				
				return pessoaEncontradas;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return new ArrayList<Pessoa>();
	}
	
	public boolean atualizarListaClientes(Pessoa cliente) {
		List<Pessoa> novaLista = listarClientes();
		novaLista.add(cliente);
		escreverJson(novaLista);
		return true;
	}
	
	public boolean escreverJson(List<Pessoa> clientes) {
		try (Writer writer = new FileWriter("cliente.json")) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(clientes, writer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
}
