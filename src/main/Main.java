package main;

import javax.swing.*;

import java.sql.Connection;

public class Main {
	
	public static void main(String[] args) {
		
		Banco banco = new Banco();
		Connection conn = banco.getConexao();

		CrudJOptionPane crud = new CrudJOptionPane();
		crud.Executar();
		
		
		System.out.println("-------------------------------------");		
		banco.fechaConexao();
		
	}

	
}