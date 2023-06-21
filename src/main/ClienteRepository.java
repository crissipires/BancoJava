package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ClienteRepository {

	public static void listaProdutos(Connection conexao) {
		Statement st = null;
		String query = "SELECT * FROM cliente";
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while (resultSet.next()) {
				Cliente cliente = new Cliente();				
				cliente.id = resultSet.getInt("id_cliente");
				cliente.nome = resultSet.getString("nome");
				cliente.cpf = resultSet.getString("cpf");
				
				System.out.println("Id: " + cliente.id
						+ " Nome: " + cliente.nome);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	
//	public void insereProduto(Connection conexao, Cliente produto) {
//		PreparedStatement ps = null;
//		String query = "INSERT INTO produtos (nome, preco)"
//				+ " VALUES (?, ?)";
//		try {
//			ps = conexao.prepareStatement(query);
//			ps.setString(1, produto.nome);
//			ps.setFloat(2, produto.preco);
//			ps.execute();
//			System.out.println("Produto Inserido com Sucesso !!!");
//		} catch (SQLException e) {			
//			System.out.println("Erro ao Iserir Produto: " + e.getMessage());
//		}
//	}
//	
//	public void editaProduto(Connection conexao) {
//		PreparedStatement ps = null;
//		String query = "UPDATE produtos SET nome = ?, preco = ?"
//				+ " WHERE id = ?";
//		int id = Integer.parseInt(
//				JOptionPane.showInputDialog("Informe o Id para editar o produto"));
//		String nome = JOptionPane.showInputDialog("Informe o Nome");
//		Float preco = Float.parseFloat(
//				JOptionPane.showInputDialog("Informe o Nome"));
//		
//		try {
//			ps = conexao.prepareStatement(query);
//			ps.setString(1, nome);
//			ps.setFloat(2, preco);
//			ps.setInt(3, id);
//			ps.execute();
//			System.out.println("Produto Alterado com Sucesso !!!");
//		} catch (SQLException e) {			
//			System.out.println("Erro ao Alterar Produto: " + e.getMessage());
//		}	
//	}
//	
//	public void removeProduto(Connection conexao) {
//		int id = Integer.parseInt(
//				JOptionPane.showInputDialog("Informe o Id para editar o produto"));
//		PreparedStatement ps = null;
//		String query = "DELETE FROM produtos WHERE id = ?";
//		try {
//			ps = conexao.prepareStatement(query);
//			ps.setInt(1, id);
//			ps.execute();
//			System.out.println("Produto Removido com Sucesso !!!");
//		} catch (SQLException e) {			
//			System.out.println("Erro ao Remover Produto: " + e.getMessage());
//		}
//	}
//	
//	public void buscaPorNome(Connection conexao) {
//		PreparedStatement ps = null;
//		String query = "SELECT * FROM produtos WHERE nome LIKE ?";
//		String nome = JOptionPane.showInputDialog("Informe o Nome");
//		nome = "%" + nome + "%";
//		
//		try {
//			ps = conexao.prepareStatement(query);
//			ps.setString(1, nome);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				Cliente produto = new Cliente();				
//				produto.id = rs.getInt("id");
//				produto.nome = rs.getString("nome");
//				produto.preco = rs.getFloat("preco");
//				
//				System.out.println("Id: " + produto.id
//						+ " Nome: " + produto.nome
//						+ " Preço: " + produto.preco);
//			}
//			rs.close();
//			ps.close();
//		} catch (SQLException e) {			
//			System.out.println("Erro ao Buscar Produto: " + e.getMessage());
//		}
//	}
	
}