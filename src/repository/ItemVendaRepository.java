package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.ItemVenda;

public class ItemVendaRepository {
	
	private Statement st;
	
	public void InserirItemVenda(Connection conexao, ItemVenda itemVenda) {
		if (itemVenda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "INSERT INTO itemVenda (Procedimento_idProcedimento, valor, Venda_idVenda) +"
				+ " VALUES (?, ?, ?)";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, itemVenda.IdProcedimento);
			ps.setFloat(2, itemVenda.Valor);
			ps.setInt(3, itemVenda.IdVenda);
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Item Venda adicionado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir item venda: " + e.getMessage());
		}
	}
	
	public void ListarItensVenda(Connection conexao) {
		String query = "SELECT * FROM itensVenda";
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while(resultSet.next()) {
				ItemVenda itemVenda = new ItemVenda();
				itemVenda.IdVenda = resultSet.getInt("Venda_idVenda");
				itemVenda.IdProcedimento = resultSet.getInt("Procedimento_idProcedimento");
				itemVenda.Valor = resultSet.getFloat("valor");
				
				System.out.println("ID da Venda: " + itemVenda.IdVenda);
				System.out.println("IdProcedimento: " +  itemVenda.IdProcedimento);
				System.out.println("Valor:" + itemVenda.Valor);
				System.out.println("----------------------");
			}
			st.close();
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar item vendas: " + e.getMessage());
		}
	}
	
	public void EditarItemVenda(Connection conexao, ItemVenda itemVenda) {
		if (itemVenda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "UPDATE itensVenda SET Procedimento_idProcedimento = ?, valor = ?" +
				"WHERE idItemVenda";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, itemVenda.IdProcedimento);
			ps.setFloat(2, itemVenda.Valor);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao editar item venda: " + e.getMessage());
		}
	}
	
	public void RemoverItemVenda(Connection conexao, int id) {
		if (id == 0) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "DELETE FROM itemVenda WHERE idItemVenda = ?";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao remover item venda: " + e.getMessage());
		}
	}
	
}