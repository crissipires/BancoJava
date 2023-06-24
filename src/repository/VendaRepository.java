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
				venda.idVenda = resultSet.getInt("idVenda");
				venda.Agenda_idAgenda = resultSet.getInt("Agenda_idAgenda");
				venda.Cliente_idCliente = resultSet.getInt("Cliente_idCliente");
				venda.Funcionario_idFuncionario = resultSet.getInt("Funcionario_idFuncionario");
				
				//ver forma de mostrar
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
			ps.setInt(1, venda.Funcionario_idFuncionario);
			ps.setInt(2, venda.Cliente_idCliente);
			ps.setInt(3, venda.Agenda_idAgenda);
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
			ps.setInt(1, venda.Funcionario_idFuncionario);
			ps.setInt(2, venda.Cliente_idCliente);
			ps.setInt(3, venda.Agenda_idAgenda);
			ps.setInt(4, venda.idVenda);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao editar venda: " + e.getMessage());
		}
	}
	
	
	

}











