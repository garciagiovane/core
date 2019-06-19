package com.garciagiovane.core.tema10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.garciagiovane.core.conexao.Conexao;

public class AgendaDAO {
	public boolean cadastrarContato(Contato contato){
		String sqlInsert = "INSERT INTO contatos (idContato, nome, telefone, email) VALUES (?, ?, ?, ?)";

		try(Connection conexao = new Conexao().inicializarConexao()) {
			PreparedStatement stmt = conexao.prepareStatement(sqlInsert);

			stmt.setString(1, null);
			stmt.setString(2, contato.getNome());
			stmt.setString(3, contato.getTelefone());
			stmt.setString(4, contato.getEmail());
			
			stmt.execute();
			System.out.println("Contato cadastrado!");
			return true;
		} catch (SQLException erroSql) {
			throw new RuntimeException();
		} 	
	}
	
	public boolean removerContato(int codigoContato){
		String sqlRemove = "DELETE FROM contatos WHERE contatos.idContato = ?";

		try (Connection conexao = new Conexao().inicializarConexao()){
			PreparedStatement stmt = conexao.prepareStatement(sqlRemove);
			stmt.setInt(1, codigoContato);
			
			stmt.executeUpdate();
			System.out.println("Contato removido!");
			return true;
		} catch (SQLException erroSql) {
			throw new RuntimeException();
		} 	
	}
	
	public List<Contato> listarContatos(){
		List<Contato> contatosEncontrados = new ArrayList<>();
		
		String sql = "SELECT * FROM contatos";

		try (Connection conexao = new Conexao().inicializarConexao()) {
			Statement stmt = conexao.createStatement();
			ResultSet dadosEncontrados = stmt.executeQuery(sql);
			
			while(dadosEncontrados.next()) {
				Contato contato = new Contato();
				contato.setIdContato(dadosEncontrados.getInt("idContato"));
				contato.setNome(dadosEncontrados.getString("nome"));
				contato.setTelefone(dadosEncontrados.getString("telefone"));
				contato.setEmail(dadosEncontrados.getString("email"));
				
				contatosEncontrados.add(contato);
			}			
			return contatosEncontrados;
		} catch (SQLException erroSql) {
			throw new RuntimeException();
		}
	}
	
	public List<Contato> buscarContatosPorParametro(String parametro){
		List<Contato> contatosEncontrados = new ArrayList<>();
		
		String sql = "SELECT * FROM contatos WHERE " + parametro;
		try (Connection conexao = new Conexao().inicializarConexao()){
			Statement stmt = conexao.createStatement();
			ResultSet dadosEncontrados = stmt.executeQuery(sql);
			
			while(dadosEncontrados.next()) { 
				Contato contato = new Contato();
				contato.setIdContato(dadosEncontrados.getInt("idContato"));
				contato.setNome(dadosEncontrados.getString("nome"));
				contato.setTelefone(dadosEncontrados.getString("telefone"));
				contato.setEmail(dadosEncontrados.getString("email"));
				
				contatosEncontrados.add(contato);
			}
			return contatosEncontrados;
		} catch (SQLException erroSql) {
			erroSql.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public List<Contato> listaOrdenada(String ordenacao){
		List<Contato> contatosEncontrados = new ArrayList<>();
		
		String sql = "SELECT * FROM contatos " + ordenacao;
		try (Connection conexao = new Conexao().inicializarConexao()){
			Statement stmt = conexao.createStatement();
			ResultSet dadosEncontrados = stmt.executeQuery(sql);
			
			while(dadosEncontrados.next()) {
				Contato contato = new Contato();
				contato.setIdContato(dadosEncontrados.getInt("idContato"));
				contato.setNome(dadosEncontrados.getString("nome"));
				contato.setTelefone(dadosEncontrados.getString("telefone"));
				contato.setEmail(dadosEncontrados.getString("email"));
				
				contatosEncontrados.add(contato);
			}
			return contatosEncontrados;
		} catch(SQLException sqlErro){
			throw new RuntimeException();
		}
	}
}
