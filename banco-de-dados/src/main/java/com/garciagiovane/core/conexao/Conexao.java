package com.garciagiovane.core.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public Connection inicializarConexao() throws SQLException {
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","");
		} catch (SQLException erroSQL) {
			throw new RuntimeException();			
		}
		return conexao;
	}
}
