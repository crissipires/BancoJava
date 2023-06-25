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
	
	public void inserirItemVenda(Connection conexao, ItemVenda itemVenda) {
		if (itemVenda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "INSERT INTO itemVenda (Procedimento_idProcedimento, valor, Venda_idVenda) +"
				+ " VALUES (?, ?, ?)";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, itemVenda.Procedimento_idProcedimento);
			ps.setFloat(2, itemVenda.valor);
			ps.setInt(3, itemVenda.idVenda);
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Item Venda adicionado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir item venda: " + e.getMessage());
		}
	}
	
	public void listarItensVenda(Connection conexao) {
		String query = "SELECT * FROM itensVenda";
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while(resultSet.next()) {
				ItemVenda itemVenda = new ItemVenda();
				itemVenda.idVenda = resultSet.getInt("idVenda");
				itemVenda.Procedimento_idProcedimento = resultSet.getInt("Procedimento_idProcedimento");
				itemVenda.valor = resultSet.getFloat("valor");
				
				//mostrar
			}
			st.close();
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar item vendas: " + e.getMessage());
		}
	}
	
	public void editarItemVenda(Connection conexao, ItemVenda itemVenda) {
		if (itemVenda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "UPDATE itensVenda SET Procedimento_idProcedimento = ?, valor = ?" +
				"WHERE idItemVenda";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, itemVenda.Procedimento_idProcedimento);
			ps.setFloat(2, itemVenda.valor);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao editar item venda: " + e.getMessage());
		}
	}
	
	public void removerItemVenda(Connection conexao, int id) {
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
