package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.ItemVenda;

public class ItemVendaRepository {
	
	private Statement st;
	
	public void Inserir(Connection conexao, ItemVenda itemVenda) {
		if (itemVenda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "INSERT INTO itensVenda (Procedimento_idProcedimento, valor, Venda_idVenda, quantidade)"
				+ " VALUES (?, ?, ?, ?)";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, itemVenda.IdProcedimento);
			ps.setFloat(2, itemVenda.Valor);
			ps.setInt(3, itemVenda.IdVenda);
			ps.setInt(4, itemVenda.quantidade);
			ps.execute();
			ps.close();
			
			JOptionPane.showMessageDialog(null, "Item Venda adicionado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir item venda: " + e.getMessage());
		}
	}
	
	public List<ItemVenda> Listar(Connection conexao) {
		String query = "SELECT * FROM itensVenda";
		List<ItemVenda> lista = new ArrayList<>();
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while(resultSet.next()) {
				ItemVenda itemVenda = new ItemVenda();
				itemVenda.IdVenda = resultSet.getInt("Venda_idVenda");
				itemVenda.IdProcedimento = resultSet.getInt("Procedimento_idProcedimento");
				itemVenda.Valor = resultSet.getFloat("valor");
				itemVenda.quantidade = resultSet.getInt("quantidade");
				
				lista.add(itemVenda);
			}
			st.close();
			resultSet.close();
		} catch (SQLException e) {
			System.out.println("Erro ao listar item vendas: " + e.getMessage());
		}
		
		return lista;
	}
	
	public void Editar(Connection conexao, ItemVenda itemVenda) {
		if (itemVenda == null) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "UPDATE itensVenda SET Procedimento_idProcedimento = ?, valor = ?, quantidade = ?" +
				"WHERE idItemVenda";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, itemVenda.IdProcedimento);
			ps.setFloat(2, itemVenda.Valor);
			ps.setInt(3, itemVenda.quantidade);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao editar item venda: " + e.getMessage());
		}
	}
	
	public void Remover(Connection conexao, int id) {
		if (id == 0) {
			return;
		}
		
		PreparedStatement ps = null;
		String query = "DELETE FROM itensVenda WHERE Venda_idVenda = ?";
		
		try {
			ps = conexao.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Erro ao remover item venda: " + e.getMessage());
		}
	}
	
}
