package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Venda;

public class VendaRepository {
	
	private Statement st;
	
	
	public void listarVendas(Connection conexao) {
		String query = "SELECT * FROM venda";
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while(resultSet.next()) {
				Venda venda = new Venda();
				venda.Id = resultSet.getInt("idVenda");
				venda.IdAgenda = resultSet.getInt("Agenda_idAgenda");
				venda.IdCliente = resultSet.getInt("Cliente_idCliente");
				venda.IdFuncionario = resultSet.getInt("Funcionario_idFuncionario");
				
				System.out.println("Id da Venda: " + venda.Id);
			    System.out.println("IdAgenda: " + venda.IdAgenda);
			    System.out.println("IdCliente: " + venda.IdCliente);
			    System.out.println("IdFuncionário: " + venda.IdFuncionario);
			    System.out.println("----------------------");
			} 
			st.close();
			resultSet.close();	
		} catch (SQLException e) {
			System.out.println("Erro ao listar vendas: " + e.getMessage());
		}
	}
	
	public void inserirVenda(Connection conexao, Venda venda) {
		if (venda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "INSERT INTO venda (Funcionario_idFuncionario, Cliente_idCliente, Agenda_idAgenda)" +
				" VALUES (?, ?, ?)";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, venda.IdFuncionario);
			ps.setInt(2, venda.IdCliente);
			ps.setInt(3, venda.IdAgenda);
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Venda inserida com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir venda: " + e.getMessage());
		}
	}
	
	public void editarVenda(Connection conexao, Venda venda) {
		if (venda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "UPDATE venda SET Funcionario_idFuncionario = ?, Cliente_idCliente = ?, Agenda_idAgenda = ? "
				+ "WHERE idVenda = ?";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, venda.IdFuncionario);
			ps.setInt(2, venda.IdCliente);
			ps.setInt(3, venda.IdAgenda);
			ps.setInt(4, venda.Id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao editar venda: " + e.getMessage());
		}
	}
	
	
	

}











