package main;

import javax.swing.*;

import model.Banco;

import java.sql.Connection;

public class Main {
	
	public static void main(String[] args) {
		
		Banco banco = new Banco();
		Connection conexao = banco.getConexao();

		CrudJOptionPane crud = new CrudJOptionPane();
		crud.Executar();
		
		
		System.out.println("-------------------------------------");		
		banco.fechaConexao();
		
	}

	
}