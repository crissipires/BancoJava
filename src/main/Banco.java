package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

	private static final String URL = "jdbc:mysql://localhost/mydb";
	private static final String USER = "root";
	private static final String SENHA = "1234";

	private Connection connection;
		
	public Connection getConexao() {
		try {
			connection = DriverManager.getConnection(URL, USER, SENHA);
			System.out.println("Conexão Aberta");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	public void fechaConexao() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Conexão Fechada");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	
}