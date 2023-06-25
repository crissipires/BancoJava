package main;

import apresentation.CrudJOptionPane;
import model.Banco;

public class Main {
	
	public static void main(String[] args) {
		
		Banco banco = new Banco();
		banco.getConexao();

		CrudJOptionPane crud = new CrudJOptionPane();
		crud.Executar();
		
		System.out.println("-------------------------------------");		
		banco.fechaConexao();
		
	}

	
}