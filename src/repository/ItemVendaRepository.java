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
import view.ViewItemVenda;

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
	
	public List<ViewItemVenda> Listar(Connection conexao) {
		String query = "SELECT * FROM viewItensVenda";
		List<ViewItemVenda> lista = new ArrayList<>();
		
		try {
			st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			
			while(resultSet.next()) {
				ViewItemVenda itemVenda = new ViewItemVenda();
				itemVenda.idVenda = resultSet.getInt("Venda_idVenda");
				itemVenda.nomeCliente = resultSet.getString("nomeCliente");
				itemVenda.valor = resultSet.getFloat("valor");
				itemVenda.descricaoProcedimento = resultSet.getString("descricaoProcedimento");
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
}
