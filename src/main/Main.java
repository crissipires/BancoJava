package main;

import java.sql.Connection;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		
		Banco banco = new Banco();
		Connection conexao = banco.getConexao();
		
		

		// ProdutoBanco pBanco = new ProdutoBanco();
		// pBanco.listaProdutos(conn);
		
		/*
		Produto p = new Produto();
		p.nome = JOptionPane.showInputDialog("Informe o Nome do produto:");
		p.preco = Float.parseFloat(
				JOptionPane.showInputDialog("Informe o Preco do produto:"));
		pBanco.insereProduto(conn, p);
		*/
		
		//pBanco.editaProduto(conn);
		
		//pBanco.removeProduto(conn);

		//pBanco.listaProdutos(conn);
		
		// System.out.println("-------------------------------------");
		// pBanco.buscaPorNome(conn);
		
		//banco.fechaConexao();
		
	}
}